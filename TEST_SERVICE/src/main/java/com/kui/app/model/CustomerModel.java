package com.kui.app.model;

import com.kui.app.entity.CustomerEntity;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link CustomerEntity}
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel implements Serializable {

    String name;
    String salary;
    List<OrderModel> orders;


}