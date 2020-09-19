package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    Item getItemById(UUID id);

    Item addItem(UUID categoryId, ItemDto item);

    List<Item> getItems();

    List<Item> getItem(UUID cid);

    Item updateItem(UUID id, ItemDto item);

    void deleteItem(UUID id);
}
