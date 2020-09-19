package com.shop_management.shop_management.controller;

import com.shop_management.shop_management.dto.RootResponseDto;
import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.service.ItemService;
import com.shop_management.shop_management.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SalesController {
    private final SalesService salesService;
    private final ItemService itemService;

    public SalesController(SalesService salesService, ItemService itemService) {

        this.salesService = salesService;
        this.itemService = itemService;
    }

    @PostMapping("/sales/{id}")
    public ResponseEntity<RootResponseDto> addSales(@PathVariable(value = "id") UUID id, @RequestBody SalesDto sales) {
        return ResponseEntity.ok(new RootResponseDto(true, "Sales added", salesService.addSales(id, sales)));

    }

}
