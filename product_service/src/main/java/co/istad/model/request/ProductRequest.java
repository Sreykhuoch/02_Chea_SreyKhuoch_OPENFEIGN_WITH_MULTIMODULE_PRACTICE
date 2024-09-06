package co.istad.model.request;


import co.istad.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private  Double price;

    public Product toEntity(){
        return new Product(null, this.name, this.price);
    }

    public Product toEntity(Long id){
        return new Product(id, this.name, this.price);
    }
}
