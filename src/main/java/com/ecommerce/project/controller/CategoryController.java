package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping("/api/public/categories")
    @RequestMapping(value ="/public/categories" , method = RequestMethod.GET )
    public ResponseEntity<List<Category> > getAllCategories()
    {

        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")
    @RequestMapping(value ="/public/categories" , method = RequestMethod.POST )
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category)
    {
       categoryService.createCategory(category);
       return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }
//    @DeleteMapping("/api/admin/categories/{categoryId}")
    @RequestMapping(value ="/admin/categories/{categoryId}" , method = RequestMethod.DELETE )
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try{
            String status  = categoryService.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(status);
//            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

//    @PutMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value ="/public/categories/{categoryId}" , method = RequestMethod.PUT)
    public  ResponseEntity<String> updateCategory(@RequestBody Category category
                                                    ,@PathVariable Long categoryId )
    {
        try{
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
