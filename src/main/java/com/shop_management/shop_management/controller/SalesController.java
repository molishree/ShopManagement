package com.shop_management.shop_management.controller;

import com.shop_management.shop_management.dto.RootResponseDto;
import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.service.ItemService;
import com.shop_management.shop_management.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SalesController {
    private final SalesService salesService;
    private final ItemService itemService;

    public SalesController(SalesService salesService, ItemService itemService) {

        this.salesService = salesService;
        this.itemService = itemService;
    }

    @GetMapping("/sales")
    public ResponseEntity<RootResponseDto> getSales() {
        return ResponseEntity.ok(new RootResponseDto(true, "displaying all sales", salesService.getSales()));
    }

    @GetMapping("/sale/{salesId}")
    public ResponseEntity<RootResponseDto> getSale(@PathVariable UUID salesId) {

        return ResponseEntity.ok(new RootResponseDto(true, "displaying sales based on item Id", salesService.getSale(salesId)));
    }

    @PostMapping("/item/{id}/sale")
    public ResponseEntity<RootResponseDto> addSales(@PathVariable(value = "id") UUID id, @RequestBody SalesDto salesDto) {
        return ResponseEntity.ok(new RootResponseDto(true, "Sales added", salesService.addSales(id, salesDto)));
    }

    @DeleteMapping("/sales/{salesId}")
    public ResponseEntity<RootResponseDto> deleteSales(@PathVariable(value = "salesId") UUID salesId) {
        salesService.deleteSales(salesId);
        return ResponseEntity.ok(new RootResponseDto(true, "item has been deleted"));
    }

}
