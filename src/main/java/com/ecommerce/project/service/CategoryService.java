package com.ecommerce.project.service;
import com.ecommerce.project.model.Category;
import java.util.List;

// use loose coupling
public interface CategoryService {
    Category updateCategory(Category category, Long categoryId);
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
   

}
