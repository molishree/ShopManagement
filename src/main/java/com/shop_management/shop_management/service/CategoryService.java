package com.shop_management.shop_management.service;

import com.shop_management.shop_management.dto.CategoryDto;
import com.shop_management.shop_management.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category addCategory(CategoryDto category);

    List<Category> getCategory();

    void deleteCategory(UUID categoryId);

    Category updateCategory(UUID categoryId, CategoryDto category);

    Category getCategoryByCategoryId(UUID categoryId);

}
