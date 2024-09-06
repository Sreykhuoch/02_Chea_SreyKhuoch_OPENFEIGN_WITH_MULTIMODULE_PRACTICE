package co.istad.feign;


import co.istad.model.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8083/api/v1/product")
public interface ProductServiceFeign {

    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id);

}
