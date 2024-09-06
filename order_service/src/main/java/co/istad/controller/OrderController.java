package co.istad.controller;


import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.ApiResponse;
import co.istad.model.response.CustomerResponse;
import co.istad.model.response.OrderResponse;
import co.istad.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse order = orderService.createOrder(orderRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        List<OrderResponse> order = orderService.getAllOrders();
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        OrderResponse order = orderService.getOrderById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderById(@PathVariable Long id, @RequestBody OrderRequest orderRequest){
        OrderResponse order = orderService.updateOrderById(id, orderRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteOrdeById(@PathVariable Long id){
        orderService.deleteOrderById(id);

        return ResponseEntity.ok("order has deleted successfully");
    }
}
