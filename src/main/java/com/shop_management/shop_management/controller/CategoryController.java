package com.shop_management.shop_management.controller;

import com.shop_management.shop_management.dto.CategoryDto;
import com.shop_management.shop_management.dto.RootResponseDto;
import com.shop_management.shop_management.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

    	this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<RootResponseDto> getAllCategories() {

        return ResponseEntity.ok(new RootResponseDto(true, "displaying all categories", categoryService.getCategory()));

    }

    @PostMapping("/category")
    public ResponseEntity<RootResponseDto> addCategory(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(new RootResponseDto(true, "Category has been added", categoryService.addCategory(category)));

    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<RootResponseDto> deleteCategory(@PathVariable("categoryId") UUID categoryId) {

        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(new RootResponseDto(true, "Category has been deleted"));

    }

    @PatchMapping("/category/{categoryId}")
    public ResponseEntity<RootResponseDto> updateCategory(@PathVariable UUID categoryId, @RequestBody CategoryDto category) {
        return ResponseEntity.ok(new RootResponseDto(true, "Category updated", categoryService.updateCategory(categoryId, category)));

    }

}
