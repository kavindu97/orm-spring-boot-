package com.kui.app.repo;

import com.kui.app.entity.OrderItemEntity;
import com.kui.app.entity.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, OrderItemPk> {
}