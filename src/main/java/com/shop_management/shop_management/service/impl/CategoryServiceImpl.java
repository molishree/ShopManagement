package com.shop_management.shop_management.service.impl;

import com.shop_management.shop_management.dao.CategoryRepository;
import com.shop_management.shop_management.dto.CategoryDto;
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
    public Category addCategory(CategoryDto category) {
        Category cat = new Category();
        cat.setName(category.getName());
        cat.setType(category.getType());
        cat.setStatus(category.getStatus());
        return categoryRepo.save(cat);
    }

    @Override
    public List<Category> getCategory() {

        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(UUID categoryId) {

        categoryRepo.deleteById(categoryId);
    }

    @Override
    public Category updateCategory(UUID categoryId, CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        Category category = categoryOptional.orElseThrow(() -> new ResourceNotFoundException("Category Id " + categoryId + " not found"));
        category.setStatus(categoryDto.getStatus());
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryByCategoryId(UUID categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category Id " + categoryId + " not found"));

    }


}
