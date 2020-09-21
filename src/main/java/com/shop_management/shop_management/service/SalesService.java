package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.model.Item;
import com.shop_management.shop_management.model.Sales;

import java.util.List;
import java.util.UUID;

public interface SalesService {
    List<Sales> getSales();
    List<Sales> getSale(UUID id);
    Sales addSales(UUID id, SalesDto salesDto);
    void deleteSales(UUID salesId);
    Sales updateSales(UUID id, SalesDto salesDto);

}
