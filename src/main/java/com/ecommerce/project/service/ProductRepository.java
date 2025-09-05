package com.ecommerce.project.service;

import com.ecommerce.project.model.Product;
import org.springframework.data.repository.Repository;

interface ProductRepository extends Repository<Product, Long> {
}
