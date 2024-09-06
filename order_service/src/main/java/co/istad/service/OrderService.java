package co.istad.service;

import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    Order getAllOrders();

    Order getOrderById(Long id);

    Order updateOrderById(Long id, OrderRequest orderRequest);

    Order deleteOrderById(Long id);
}
