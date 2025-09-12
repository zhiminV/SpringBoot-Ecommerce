package com.ecommerce.project.payload;

import com.ecommerce.project.model.Cart;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long cartId;
    private double totalPrice = 0.0;
    private List<ProductDTO> products = new ArrayList<>();


}
