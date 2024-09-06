package co.istad.service.serviceImpl;

import co.istad.model.Product;
import co.istad.model.request.ProductRequest;
import co.istad.repository.ProductRepository;
import co.istad.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = productRequest.toEntity();
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found !!")
        );

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) {
        if(productRepository.findById(id).isPresent()){
            Product product = productRequest.toEntity(id);
            return productRepository.save(product);
        }

        throw new RuntimeException("Product not found !!");
    }

    @Override
    public void deleteProductById(Long id) {
        Product  product = productRepository.findById(id).orElseThrow(
                ()  -> new RuntimeException("Product not found !!")
        );

         productRepository.delete(product);
    }


}
