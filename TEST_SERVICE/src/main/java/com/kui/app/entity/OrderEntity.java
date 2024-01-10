package com.kui.app.entity;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;


@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "date")
    private Date date;
    @Column(name = "total_amount")
    private Double totalAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany(mappedBy = "pk.order",cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;

    public OrderEntity(Integer orderId, Date date, Double totalAmount, CustomerEntity customer, List<OrderItemEntity> orderItems) {
        this.orderId = orderId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public OrderEntity() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }
}
