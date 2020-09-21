package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.CategoryDto;
import com.shop_management.shop_management.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getCategory();
    Category getCategoryByCategoryId(UUID categoryId);
    Category addCategory(CategoryDto categoryDto);
    void deleteCategory(UUID categoryId);
    Category updateCategory(UUID categoryId, CategoryDto categoryDto);
}
