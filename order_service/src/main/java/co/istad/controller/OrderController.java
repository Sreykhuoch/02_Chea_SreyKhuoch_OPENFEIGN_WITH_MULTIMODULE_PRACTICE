package co.istad.controller;


import co.istad.model.Order;
import co.istad.model.request.OrderRequest;
import co.istad.model.response.ApiResponse;
import co.istad.model.response.OrderResponse;
import co.istad.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        Order order = orderService.getAllOrders();
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrderById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderById(@PathVariable Long id, @RequestBody OrderRequest orderRequest){
        Order order = orderService.updateOrderById(id, orderRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteOrdeById(@PathVariable Long id){
        Order order = orderService.deleteOrderById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Order created successfully")
                .status(HttpStatus.CREATED)
                .payload(order)
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}
