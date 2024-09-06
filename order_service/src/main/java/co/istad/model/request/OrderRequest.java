package co.istad.model.request;




import co.istad.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {
    private Long customerId;
    private List<Long> productIds;

    public Order toEntity(){
      return new Order(null,this.customerId, productIds, LocalDate.now());
    }

    public Order toEntity(Long id){
        return new Order(id,this.customerId, productIds, LocalDate.now());
    }

}
