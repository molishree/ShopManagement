package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.ItemRepository;
import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.exception.ResourceNotFoundException;
import com.shop_management.shop_management.model.Item;
import com.shop_management.shop_management.service.CategoryService;
import com.shop_management.shop_management.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepo;

    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepo, CategoryService categoryService) {
        this.itemRepo = itemRepo;
        this.categoryService = categoryService;
    }

    @Override
    public Item addItem(UUID categoryId, ItemDto item) {
        Item it = new Item();
        it.setName(item.getName());
        it.setAmount(item.getAmount());
        it.setQuantity(item.getQuantity());
        it.setStatus(item.getStatus());
        it.setCategory(categoryService.getCategoryByCategoryId(categoryId));
        return itemRepo.save(it);
    }


    @Override
    public List<Item> getItems() {

        return itemRepo.findAll();
    }

    @Override
    public List<Item> getItem(UUID categoryId) {

        List<Item> itemFound = itemRepo.findByCategoryCategoryId(categoryId);

        if (itemFound.isEmpty()) {
            throw new ResourceNotFoundException("Category Id " + categoryId + " not found");
        }

        return itemFound;
    }

    @Override
    public void deleteItem(UUID id) {
        itemRepo.deleteById(id);

    }

    @Override
    public Item updateItem(UUID id, ItemDto item) {
        Optional<Item> itemData = itemRepo.findById(id);
        itemData.orElseThrow(() -> new ResourceNotFoundException("Item with id " + id + " not found"));

        Item newItem = itemData.get();

        int itemQuantity = newItem.getQuantity() + item.getQuantity();
        if (itemQuantity < 0) {
            throw new ResourceNotFoundException("Item Quantity can not be negative");
        }

        newItem.setQuantity(newItem.getQuantity() + item.getQuantity());

        return itemRepo.save(newItem);

    }

    @Override
    public Item getItemById(UUID id) {
        return itemRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item with id " + id + "not found"));
    }

}
