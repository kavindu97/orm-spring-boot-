package com.kui.app.repo;

import com.kui.app.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends JpaRepository<ItemEntity, Integer> {
}