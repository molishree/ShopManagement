package com.shop_management.shop_management.dao;

import com.shop_management.shop_management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    List<Item> findByCategoryCategoryId(UUID categoryId);

}
