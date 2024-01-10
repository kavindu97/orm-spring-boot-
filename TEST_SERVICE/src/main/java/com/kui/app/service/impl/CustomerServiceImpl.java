package com.kui.app.service.impl;

import com.kui.app.entity.ItemEntity;
import com.kui.app.entity.OrderItemEntity;
import com.kui.app.entity.pk.OrderItemPk;
import com.kui.app.model.CustomerModel;
import com.kui.app.entity.CustomerEntity;
import com.kui.app.entity.OrderEntity;
import com.kui.app.model.OrderModel;
import com.kui.app.repo.CustomerEntityRepository;
import com.kui.app.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerEntityRepository customerRepository;

    public CustomerServiceImpl(CustomerEntityRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Transactional
    @Override
    public void add(CustomerModel model) {
        try {if (model == null) {
            throw new RuntimeException("Customer Data not found");
        }

            CustomerEntity customer = new CustomerEntity();
            customer.setName(model.getName());
            customer.setSalary(model.getSalary());

            List<OrderEntity> orderEntities = new ArrayList<>();

            for (OrderModel items : model.getOrders()) {
                List<OrderItemEntity> orderItemEntities = new ArrayList<>();

                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setCustomer(customer);
                orderEntity.setTotalAmount(items.getTotalAmount());
                orderEntity.setDate(new Date(System.currentTimeMillis()));

                OrderItemEntity orderItemEntity = new OrderItemEntity();
                orderItemEntity.setOrder(orderEntity);

                ItemEntity item = new ItemEntity();
                item.setPrice(0.00);
                item.setItemName("teddy");
                item.setQuantity(2);

                orderItemEntity.setItem(item);

                OrderItemPk pk = new OrderItemPk();
                pk.setItem(item);
                pk.setOrder(orderEntity);
                orderItemEntity.setPk(pk);
                orderItemEntity.setPrice(0.00);
                orderItemEntity.setQuantity(2);

                orderItemEntities.add(orderItemEntity);
                orderEntity.setOrderItems(orderItemEntities);
                item.setOrderItems(orderItemEntities);

                // Additional adjustment: Set the OrderItemEntity in the ItemEntity
                item.getOrderItems().add(orderItemEntity);

                orderEntities.add(orderEntity);
            }

            customer.setOrders(orderEntities);
            customerRepository.save(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(CustomerModel model,Integer id) {
        Optional<CustomerEntity> getOne=customerRepository.findById(id);
        CustomerEntity customerEntity=getOne.get();
        customerEntity.setName(model.getName());

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<CustomerModel> findAll() {

        List<CustomerEntity> getAll=customerRepository.findAll();
        List<CustomerModel> getAllCustomers=getAll.stream().map(items->{
            CustomerModel customerModel=new CustomerModel();
            customerModel.setName(items.getName());
            customerModel.setSalary(items.getSalary());
            customerModel.setOrders(getOrders(items.getOrders()));
            return customerModel;
        }).distinct().collect(Collectors.toList());
//        for (CustomerEntity items: getAll) {
//            CustomerModel customerModel=new CustomerModel();
//            customerModel.setName(items.getName());
//            customerModel.setSalary(items.getSalary());
//            customerModel.setOrders(getOrders(items.getOrders()));
//            getAllCustomers.add(customerModel);
//        }

        List<CustomerEntity> test=     getAll.stream().filter(item->
                        item.getName().equals("Test")||item.getName().equals("t"))
                .map(item-> {item.setSalary(item.getSalary()+item.getName());
            return item;
        }).collect(Collectors.toList());
        return getAllCustomers;
    }


    @Override
    public CustomerModel findOne(Integer id) {
        Optional<CustomerEntity> getOne=customerRepository.findById(id);
        CustomerEntity customerEntity=getOne.get();
        CustomerModel customerModel= new CustomerModel();
        customerModel.setName(customerEntity.getName());
        customerModel.setSalary(customerEntity.getSalary());
        customerModel.setOrders(getOrders(customerEntity.getOrders()));
        return  customerModel;
    }
    public List<OrderModel> getOrders(List<OrderEntity> orders){
        List<OrderModel> ordersModels=new ArrayList<>();
        for (OrderEntity items:orders) {
            OrderModel orderModel=new OrderModel();
            orderModel.setTotalAmount(items.getTotalAmount());
            ordersModels.add(orderModel);
        }

        return ordersModels;
    }

}
