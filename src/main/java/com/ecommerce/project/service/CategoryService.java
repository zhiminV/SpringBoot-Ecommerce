package com.ecommerce.project.service;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;

import java.util.List;

// use loose coupling
public interface CategoryService {
    CategoryDTO updateCategory(CategoryDTO CategoryDTO, Long categoryId);
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO createCategory(CategoryDTO CategoryDTO);
    CategoryDTO deleteCategory(Long categoryId);

}
