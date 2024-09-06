package co.istad.service;

import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderResponse updateOrderById(Long id, OrderRequest orderRequest);

    void deleteOrderById(Long id);
}
