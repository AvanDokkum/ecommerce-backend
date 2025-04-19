package com.webcanis.ecommerce_backend.controller;

import com.webcanis.ecommerce_backend.model.Category;
import com.webcanis.ecommerce_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories" , method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories" , method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully.", HttpStatus.CREATED);
    }

//    @DeleteMapping("/admin/categories/{categoryId}")
    @RequestMapping(value = "/admin/categories/{categoryId}" , method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
//            multiple ways of doing declaring the same response entity
//            return ResponseEntity.ok(status);
//            return ResponseEntity.status(HttpStatus.OK).body(status);
            return new ResponseEntity<>(status, HttpStatus.OK);

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }



}
