package org.demo.customerservice.services;

import org.demo.customerservice.dto.CustomerRequestDTO;
import org.demo.customerservice.dto.CustomerResponseDTO;
import org.demo.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id) throws CustomerNotFoundException;
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getCustomers();
}
