package com.kui.app.entity.pk;

import com.kui.app.entity.ItemEntity;
import com.kui.app.entity.OrderEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPk implements Serializable {

    private ItemEntity item;

    private OrderEntity order;
    @ManyToOne
    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
    @ManyToOne
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
