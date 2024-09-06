package co.istad.service.orderServiceImpl;


import co.istad.feign.CustomerServiceFeign;
import co.istad.feign.ProductServiceFeign;
import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.ApiResponse;
import co.istad.model.response.CustomerResponse;
import co.istad.model.response.OrderResponse;
import co.istad.model.response.ProductResponse;
import co.istad.repository.OrderRepository;
import co.istad.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerServiceFeign customerServiceFeign;
    private final ProductServiceFeign productServiceFeign;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Order order = new Order();
        ResponseEntity<ApiResponse<CustomerResponse>> getCustomerById= customerServiceFeign.getCustomerById(orderRequest.getCustomerId());
        CustomerResponse customerResponse = getCustomerById.getBody().getPayload();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductIds(orderRequest.getProductIds());
        order.setOrderDate(orderRequest.toEntity().getOrderDate());


        List<ProductResponse> productResponses = new ArrayList<>();
        for (Long productId : orderRequest.getProductIds()) {
            ResponseEntity<ApiResponse<ProductResponse>> product = productServiceFeign.getProductById(productId);
            productResponses.add(product.getBody().getPayload());
        }
        orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCustomerResponse(customerResponse);
        orderResponse.setProductResponse(productResponses);
        orderResponse.setOrderDate(order.getOrderDate());
        return orderResponse;

    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderResponse> orderResponseList= new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            OrderResponse orderResponse = getOrderById(order.getId());
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;

    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order not found")
        );
        CustomerResponse customerResponse = customerServiceFeign.getCustomerById(order.getCustomerId()).getBody().getPayload();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Long productId : order.getProductIds() ){
            ProductResponse productResponse = productServiceFeign.getProductById(productId).getBody().getPayload();
            productResponseList.add(productResponse);
        }
        return order.toResponse(customerResponse, productResponseList);
    }

    @Override
    public OrderResponse updateOrderById(Long id, OrderRequest orderRequest) {
        OrderResponse orderResponse =  getOrderById(id);
        orderRepository.save(orderRequest.toEntity(id));
        return orderResponse;
    }

    @Override
    public void deleteOrderById(Long id) {
       if(orderRepository.findById(id).isEmpty()){
           throw new RuntimeException(" order is not found");
       }
       orderRepository.deleteById(id);
    }
}
