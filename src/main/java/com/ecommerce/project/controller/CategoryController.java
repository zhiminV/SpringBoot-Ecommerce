package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
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

    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage (@RequestParam(name = "message") String massage) {
        return new ResponseEntity<>("Echoed message: " + massage, HttpStatus.OK);
    }

//    @GetMapping("/api/public/categories")
    @RequestMapping(value ="/public/categories" , method = RequestMethod.GET )
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name="pageNumber") Integer pageNumber,
            @RequestParam(name="pageSize") Integer pageSize
    )
    {
        CategoryResponse CategoryResponse = categoryService.getAllCategories(pageNumber, pageSize);
        return new ResponseEntity<>(CategoryResponse, HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")
    @RequestMapping(value ="/public/categories" , method = RequestMethod.POST )
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO CategoryDTO)
    {
       CategoryDTO savedCategoryDTO = categoryService.createCategory(CategoryDTO);
       return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }
//    @DeleteMapping("/api/admin/categories/{categoryId}")
    @RequestMapping(value ="/admin/categories/{categoryId}" , method = RequestMethod.DELETE )
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
            CategoryDTO deleteCategory  = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deleteCategory, HttpStatus.OK);
    }

//    @PutMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value ="/public/categories/{categoryId}" , method = RequestMethod.PUT)
    public  ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO CategoryDTO
                                                    ,@PathVariable Long categoryId )
    {
        //claas is CategoryDTO, we create an object savedCategory
        CategoryDTO savedCategory = categoryService.updateCategory(CategoryDTO, categoryId);
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);

    }
}
