package com.kui.app.controller;

import com.kui.app.model.CustomerModel;
import com.kui.app.model.ResponseModel;
import com.kui.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addCustomer(@RequestBody CustomerModel model){
        customerService.add(model);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-all")
    public List<CustomerModel> getAll(){
        return customerService.findAll();
    }
    @GetMapping("/get-one/{id}")
    public CustomerModel findOne(@PathVariable Integer id){
        return customerService.findOne(id);
    }
    @PutMapping("/update-one")
    public void findOne(@RequestBody CustomerModel model,@PathVariable  Integer id){
        customerService.update(model,id);
    }

}
