package co.istad.model.response;


import co.istad.model.request.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long  id;
    private CustomerResponse customerResponse;
    private List<ProductResponse> productResponse;
    private LocalDate orderDate;

}
