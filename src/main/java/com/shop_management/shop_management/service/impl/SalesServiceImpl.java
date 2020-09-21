package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.SalesRepository;
import com.shop_management.shop_management.dto.ItemDto;
import com.shop_management.shop_management.dto.SalesDto;
import com.shop_management.shop_management.exception.BadRequestException;
import com.shop_management.shop_management.exception.ResourceNotFoundException;
import com.shop_management.shop_management.model.Item;
import com.shop_management.shop_management.model.Sales;
import com.shop_management.shop_management.service.ItemService;
import com.shop_management.shop_management.service.SalesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public List<Sales> getSales() {

        return salesRepo.findAll();
    }

    public List<Sales> getSale(UUID id) {
        List<Sales> saleFound = salesRepo.findByItemId(id);
        if (saleFound.isEmpty()) {
            throw new ResourceNotFoundException("Item Id " + id + " not found");
        }
        return saleFound;
    }

    @Override
    public Sales addSales(UUID id, SalesDto salesDto) {
        Sales sale = new Sales();
        sale.setAmount(salesDto.getAmount());
        sale.setQuantity(salesDto.getQuantity());
        Item item = itemService.getItemById(id);
        item.setQuantity(item.getQuantity()-sale.getQuantity());
        sale.setItem(item);
        return salesRepo.save(sale);
    }

    @Override
    public void deleteSales(UUID salesId) {

        salesRepo.deleteById(salesId);
    }

    @Override
    public Sales updateSales(UUID salesId, SalesDto salesDto) {
        Optional<Sales> salesData = salesRepo.findById(salesId);
        salesData.orElseThrow(() -> new ResourceNotFoundException("Sales with id " + salesId + " not found"));
        Sales newSale = salesData.get();

        if(salesDto.getAmount()!=0){
            newSale.setAmount(salesDto.getAmount());
        }

        int salesQuantity = newSale.getQuantity() + salesDto.getQuantity();
        if (salesQuantity < 0) {
            throw new BadRequestException("Item Quantity can not be negative");
        }

        if(salesDto.getQuantity()!=0) {
            newSale.setQuantity(salesQuantity);
        }
        return salesRepo.save(newSale);
    }

}
