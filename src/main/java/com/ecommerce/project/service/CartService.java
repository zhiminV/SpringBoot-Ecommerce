package com.ecommerce.project.service;

import com.ecommerce.project.payload.CartDTO;

public interface CartService {
    CartDTO addProductTOCart(Long productId, Integer quantity);
}
