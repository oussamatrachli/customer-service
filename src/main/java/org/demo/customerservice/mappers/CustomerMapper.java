package org.demo.customerservice.mappers;

import org.demo.customerservice.dto.CustomerRequestDTO;
import org.demo.customerservice.dto.CustomerResponseDTO;
import org.demo.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
