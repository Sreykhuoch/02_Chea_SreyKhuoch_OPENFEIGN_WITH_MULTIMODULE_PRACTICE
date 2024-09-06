package co.istad.service;

import co.istad.model.Product;
import co.istad.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);

    Product getProductById(Long id);

    List<Product> getAllProduct();

    Product updateProduct(Long id, ProductRequest productRequest);

    void deleteProductById(Long id);
}
