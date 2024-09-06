package co.istad.controller;


import co.istad.model.Customer;
import co.istad.model.request.CustomerRequest;
import co.istad.model.response.ApiResponse;
import co.istad.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

   @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest) {
       Customer customer = customerService.createCustomer(customerRequest);
       ApiResponse<?> apiResponse  = ApiResponse.builder()
               .message("Customer created successfully")
               .status(HttpStatus.CREATED)
               .payload(customer)
               .time(LocalDateTime.now())
               .build();
       return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        List<Customer> customers = customerService.getAllCustomer();
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .message("Customers fetched successfully")
                .status(HttpStatus.OK)
                .payload(customers)
                .time(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
       Customer customer = customerService.getCustomer(id);
       ApiResponse<?> apiResponse = ApiResponse.builder()
                    .message("Customer fetched successfully")
                    .status(HttpStatus.OK)
                    .payload(customer)
                    .time(LocalDateTime.now())
                    .build();

            return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest ){
       Customer customer = customerService.updateCustomer(id, customerRequest);
       ApiResponse<?> apiResponse = ApiResponse.builder()
               .message("update customer successfully")
               .status(HttpStatus.OK)
               .payload(customer)
               .time(LocalDateTime.now())
               .build();

       return ResponseEntity.ok(apiResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
       customerService.deleteCustomer(id);
         return ResponseEntity.ok( "customer id : "+id+" has been deleted successfully");
    }

}
