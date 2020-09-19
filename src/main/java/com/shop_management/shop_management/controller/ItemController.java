package com.shop_management.shop_management.controller;

import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.dto.RootResponseDto;
import com.shop_management.shop_management.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {

        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<RootResponseDto> getItems() {

        return ResponseEntity.ok(new RootResponseDto(true, "displaying all items", itemService.getItems()));

    }

    @GetMapping("/items/{categoryId}")
    public ResponseEntity<RootResponseDto> getItem(@PathVariable UUID categoryId) {

        return ResponseEntity.ok(new RootResponseDto(true, "displaying items based on category Id", itemService.getItem(categoryId)));
    }

    @PostMapping("/category/{categoryId}/item")
    public ResponseEntity<RootResponseDto> addItem(
            @PathVariable(value = "categoryId") UUID categoryId,
            @RequestBody ItemDto item) {

        return ResponseEntity.ok(new RootResponseDto(true, "item has been added", itemService.addItem(categoryId, item)));
    }


    @DeleteMapping("/item/{id}")
    public ResponseEntity<RootResponseDto> deleteItem(@PathVariable(value = "id") UUID id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok(new RootResponseDto(true, "item has been deleted"));
    }

    @PatchMapping("/item/{id}")
    public ResponseEntity<RootResponseDto> updateItem(
            @PathVariable(value = "id") UUID id,
            @RequestBody ItemDto item) {
        return ResponseEntity.ok(new RootResponseDto(true, "item has been updated"
                , itemService.updateItem(id, item)));
    }


}
