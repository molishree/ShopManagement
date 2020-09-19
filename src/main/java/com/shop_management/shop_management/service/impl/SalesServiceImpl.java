package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.SalesRepository;
import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.model.Sales;
import com.shop_management.shop_management.service.ItemService;
import com.shop_management.shop_management.service.SalesService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesServiceImpl implements SalesService {

    private SalesRepository salesRepo;
    private ItemService itemService;

    public SalesServiceImpl(SalesRepository salesRepo, ItemService itemService) {

        this.salesRepo = salesRepo;
        this.itemService = itemService;
    }

    @Override
    public Sales addSales(UUID id, SalesDto sales) {
        Sales sal = new Sales();
        sal.setQuantity(sal.getQuantity());
        sal.setAmount(sal.getAmount());
        sal.setItem(itemService.getItemById(id));
        return salesRepo.save(sal);

    }

}
