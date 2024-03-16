package org.demo.customerservice;

import org.demo.customerservice.dto.CustomerRequestDTO;
import org.demo.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("C01", "Customer01", "customer01@cdbx.biz"));
			customerService.save(new CustomerRequestDTO("C02", "Customer02", "customer02@cdbx.biz"));
			customerService.save(new CustomerRequestDTO("C03", "Customer03", "customer03@cdbx.biz"));
		};
	}
}
