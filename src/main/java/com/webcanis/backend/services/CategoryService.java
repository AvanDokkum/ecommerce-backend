package com.webcanis.backend.services;

import com.webcanis.backend.models.Category;
import com.webcanis.backend.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

}
