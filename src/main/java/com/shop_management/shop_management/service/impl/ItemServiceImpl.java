package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.ItemRepository;
import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.exception.BadRequestException;
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
    public Item getItemById(UUID id) {
        return itemRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item id " + id + " not found"));
    }

    @Override
    public Item addItem(UUID categoryId, ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setAmount(itemDto.getAmount());
        item.setQuantity(itemDto.getQuantity());
        if(itemDto.getStatus().equals("accept") || itemDto.getStatus().equals("unaccept")) {
            item.setStatus(itemDto.getStatus());
        }else{
            throw new BadRequestException("Status of the category needs to be checked");
        }
        item.setCategory(categoryService.getCategoryByCategoryId(categoryId));
        return itemRepo.save(item);
    }

    @Override
    public void deleteItem(UUID id) {
        itemRepo.deleteById(id);
    }

    @Override
    public Item updateItem(UUID id, ItemDto itemDto) {
        Optional<Item> itemData = itemRepo.findById(id);
        itemData.orElseThrow(() -> new ResourceNotFoundException("Item with id " + id + " not found"));
        Item newItem = itemData.get();
        if(itemDto.getName()!=null){
            newItem.setName(itemDto.getName());
        }
        if(itemDto.getStatus()!=null){
            newItem.setStatus(itemDto.getStatus());
        }
        if(itemDto.getAmount()!=0){
            newItem.setAmount(itemDto.getAmount());
        }
        if(itemDto.getQuantity()!=0) {
            int itemQuantity = newItem.getQuantity() + itemDto.getQuantity();
            if (itemQuantity < 0) {
                throw new BadRequestException("Item Quantity can not be negative");
            }
            newItem.setQuantity(itemQuantity);
        }
        return itemRepo.save(newItem);
    }
}
