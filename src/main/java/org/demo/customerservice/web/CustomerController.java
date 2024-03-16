package org.demo.customerservice.web;

import org.demo.customerservice.dto.CustomerRequestDTO;
import org.demo.customerservice.dto.CustomerResponseDTO;
import org.demo.customerservice.exceptions.CustomerNotFoundException;
import org.demo.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping(path = "/customer")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "customer/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }
}
