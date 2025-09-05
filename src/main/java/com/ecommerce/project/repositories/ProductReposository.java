package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposository extends JpaRepository<Product, Long> {
}
