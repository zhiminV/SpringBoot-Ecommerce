package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category> > getAllCategories()
    {

        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
       categoryService.addCategory(category);
       return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try{
            String status  = categoryService.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(status);
//            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }



    }
}
