package com.shop_management.shop_management.dao;

import com.shop_management.shop_management.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sales, UUID> {

}
