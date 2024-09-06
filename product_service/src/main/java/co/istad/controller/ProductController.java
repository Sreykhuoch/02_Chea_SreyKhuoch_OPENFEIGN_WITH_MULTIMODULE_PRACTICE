package co.istad.controller;


import co.istad.model.Product;
import co.istad.model.request.ProductRequest;
import co.istad.model.response.ApiResponse;
import co.istad.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Product created successfully")
                .status(HttpStatus.CREATED)
                .payload(product)
                .time(LocalDateTime.now())
                .build();


        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Product fetched successfully")
                .status(HttpStatus.OK)
                .payload(product)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        List<Product> productList = productService.getAllProduct();
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Product fetched successfully")
                .status(HttpStatus.OK)
                .payload(productList)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        Product product = productService.updateProduct(id, productRequest);
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Product updated successfully")
                .status(HttpStatus.OK)
                .payload(product)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok("product with id : "+ id + " has been deleted successfully");
    }
}
