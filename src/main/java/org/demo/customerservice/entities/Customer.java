package org.demo.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA Entity
@Data @NoArgsConstructor @AllArgsConstructor // @Data: Getters and Setters @NoArgsConstructor: Constructor with no arguments @AllArgsConstructor: Constructor with all arguments
public class Customer {
    @Id // Id of JPA entity
    private String id;
    private String name;
    private String email;
}
