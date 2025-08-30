package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category>  optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        //first find the category that need to delete
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        categories.remove(category);
        return "Category with " + categoryId + " deleted successfully";
    }
}
