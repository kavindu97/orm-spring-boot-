package com.kui.app.service;

import com.kui.app.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    void add(CustomerModel model);
    void update(CustomerModel model,Integer id);
    void delete(Integer id);
    List<CustomerModel> findAll();
    CustomerModel findOne(Integer id);
}
