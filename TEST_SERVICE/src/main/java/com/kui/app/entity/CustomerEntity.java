package com.kui.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private String salary;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}
