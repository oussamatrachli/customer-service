package org.demo.customerservice.services;

import org.demo.customerservice.dto.CustomerRequestDTO;
import org.demo.customerservice.dto.CustomerResponseDTO;
import org.demo.customerservice.entities.Customer;
import org.demo.customerservice.exceptions.CustomerNotFoundException;
import org.demo.customerservice.mappers.CustomerMapper;
import org.demo.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);

        Customer savedCustomer = customerRepository.save(customer);


        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> customerMapper.customerToCustomerResponseDTO(customer)).collect(Collectors.toList());
    }
}
