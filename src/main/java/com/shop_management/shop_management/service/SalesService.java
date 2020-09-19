package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.model.Sales;

import java.util.UUID;

public interface SalesService {

    Sales addSales(UUID id, SalesDto sales);
}
