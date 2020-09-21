package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    List<Item> getItems();
    List<Item> getItem(UUID categoryId);
    Item getItemById(UUID id);
    Item addItem(UUID categoryId, ItemDto itemDto);
    void deleteItem(UUID id);
    Item updateItem(UUID id, ItemDto itemDto);
}
