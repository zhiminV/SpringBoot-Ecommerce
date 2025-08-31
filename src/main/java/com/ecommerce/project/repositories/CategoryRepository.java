package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    // if we want to define class that not exit, use JPA, do not need to create interface and extend
    Category findByCategoryName(String categoryName);
}
