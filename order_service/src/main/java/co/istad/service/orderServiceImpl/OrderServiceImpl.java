package co.istad.service.orderServiceImpl;


import co.istad.feign.CustomerServiceFeign;
import co.istad.feign.ProductServiceFeign;
import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.CustomerResponse;
import co.istad.model.response.OrderResponse;
import co.istad.model.response.ProductResponse;
import co.istad.repository.OrderRepository;
import co.istad.service.OrderService;
import lombok.AllArgsConstructor;
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

        ProductResponse productResponse;
        Order order = new Order();

        CustomerResponse customerResponse = customerServiceFeign.getCustomerById(orderRequest.getCustomerId());

        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Long productId : orderRequest.getProductIds()) {
            productResponse = productServiceFeign.getProductById(productId);
            productResponseList.add(productResponse);
        }



      return null;
    }

    @Override
    public Order getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public Order updateOrderById(Long id, OrderRequest orderRequest) {
        return null;
    }

    @Override
    public Order deleteOrderById(Long id) {
        return null;
    }
}
