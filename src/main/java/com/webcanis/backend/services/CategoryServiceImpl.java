package com.webcanis.backend.services;

import com.webcanis.backend.exceptions.APIException;
import com.webcanis.backend.exceptions.ResourceNotFoundException;
import com.webcanis.backend.models.Category;
import com.webcanis.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()){
            throw new APIException("No category created yet.");
        }
        return categories;
    }


    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null){
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists.");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        categoryRepository.delete(category);
        return "Category with categoryId-" + categoryId + " deleted successfully.";
    }

    //old code:
//        List<Category> categories = categoryRepository.findAll();
//
//        category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found."));
//        if (category == null)
//            return "category not found";
//        categoryRepository.delete(category);
//        return "Category with categoryId-" + categoryId + " deleted successfully.";

//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found."));
//        if (category == null)
//            return "category not found";
//        categories.remove(category);
//        return "Category with categoryId-" + categoryId + " deleted successfully.";


    @Override
    public Category updateCategory(Category category, Long categoryId) {

        //if Category exists it is assigned to savedCategory, else the error is being thrown
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        //better implementations for checking existence of Category
        //1: "Use existsById() for performance"

//        if (!categoryRepository.existsById(categoryId)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
//        }

        //2: "Extract the validation into a separate method, handy if this occurs more often"

//        private void assertCategoryExists(Long categoryId) {
//            if (!categoryRepository.existsById(categoryId)) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found.");
//            }
//        }
//
//        @Override
//        public Category updateCategory(Category category, Long categoryId) {
//            assertCategoryExists(categoryId);
//
//            category.setCategoryId(categoryId);
//            return categoryRepository.save(category);
//        }

        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }

    //old code:
//        List<Category> categories = categoryRepository.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//        if (optionalCategory.isPresent()){
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(existingCategory);
//            return savedCategory;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
//        }


}
