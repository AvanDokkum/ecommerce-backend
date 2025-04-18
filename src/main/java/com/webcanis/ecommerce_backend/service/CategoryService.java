package com.webcanis.ecommerce_backend.service;

import com.webcanis.ecommerce_backend.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

}
