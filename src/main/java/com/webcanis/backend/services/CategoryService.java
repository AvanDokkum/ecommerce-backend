package com.webcanis.backend.services;

import com.webcanis.backend.models.Category;
import com.webcanis.backend.payload.CategoryDTO;
import com.webcanis.backend.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);

}
