package com.kui.app.entity;

import com.kui.app.entity.pk.OrderItemPk;
import jakarta.persistence.*;

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "pk.item", joinColumns = @JoinColumn(name = "item_id")),
        @AssociationOverride(name = "pk.order", joinColumns = @JoinColumn(name = "order_id"))
})
public class OrderItemEntity {

    private OrderItemPk pk = new OrderItemPk();

    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderItemPk pk, Integer quantity, Double price) {
        this.pk = pk;
        this.quantity = quantity;
        this.price = price;
    }

    @EmbeddedId
    public OrderItemPk getPk() {
        return this.pk;
    }

    public void setPk(OrderItemPk pk) {
        this.pk = pk;
    }

    @Transient
    public ItemEntity getItem() {
        return getPk().getItem();
    }

    public void setItem(ItemEntity itemEntity) {
        getPk().setItem(itemEntity);
    }

    @Transient
    public OrderEntity getOrder() {
        return getPk().getOrder();
    }

    public void setOrder(OrderEntity orderEntity) {
        getPk().setOrder(orderEntity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
