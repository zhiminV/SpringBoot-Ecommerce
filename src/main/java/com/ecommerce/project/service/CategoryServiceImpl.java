package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    private Long nextId = 1L;

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
                .findFirst().orElse(null);
        if (category == null) {
            return "Category not found";
        }
        categories.remove(category);
        return "Category with " + categoryId + " deleted successfully";
    }
}
