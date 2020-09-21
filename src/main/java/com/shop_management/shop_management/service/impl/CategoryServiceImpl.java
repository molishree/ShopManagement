package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.CategoryRepository;
import com.shop_management.shop_management.dto.CategoryDto;
import com.shop_management.shop_management.exception.BadRequestException;
import com.shop_management.shop_management.exception.ResourceNotFoundException;
import com.shop_management.shop_management.model.Category;
import com.shop_management.shop_management.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryByCategoryId(UUID categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category Id " + categoryId + " not found"));
    }

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        if(categoryDto.getType().equals("essential") || categoryDto.getType().equals("nonessential")) {
            category.setType(categoryDto.getType());
        }else {
            throw new BadRequestException("Type of the category needs to be checked");
        }

        if(categoryDto.getStatus().equals("accept") || categoryDto.getStatus().equals("unaccept")) {
            category.setStatus(categoryDto.getStatus());
        }else {
            throw new BadRequestException("Status of the category needs to be checked");
        }

        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(UUID categoryId) {
            categoryRepo.deleteById(categoryId);
    }

    @Override
    public Category updateCategory(UUID categoryId, CategoryDto categoryDto) {
        Optional<Category> categoryData = categoryRepo.findById(categoryId);
        categoryData.orElseThrow(() -> new ResourceNotFoundException("Category Id " + categoryId + " not found"));
        Category category = categoryData.get();
        if(categoryDto.getStatus()!=null) {
            category.setStatus(categoryDto.getStatus());
        }
        if(categoryDto.getType()!=null) {
            category.setType(categoryDto.getType());
        }
        if(categoryDto.getName()!=null) {
            category.setName(categoryDto.getName());
        }
        return categoryRepo.save(category);
    }
}
