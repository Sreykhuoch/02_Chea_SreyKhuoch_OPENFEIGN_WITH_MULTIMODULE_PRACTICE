package co.istad.model;


import co.istad.model.response.CustomerResponse;
import co.istad.model.response.OrderResponse;
import co.istad.model.response.ProductResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;

    @ElementCollection
    private List<Long> productIds;
    private LocalDate orderDate;


    public OrderResponse toResponse(CustomerResponse customerResponse, List<ProductResponse> productResponses) {
        return new OrderResponse(
                this.id, customerResponse, productResponses, this.orderDate
        );
    }

}
