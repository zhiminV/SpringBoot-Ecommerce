package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.user.email = ?1")
    Cart findByUserEmail(String email);

    @Query("SELECT c FROM Cart c WHERE c.user.email = ?1 and c.cartId = ?2")
    Cart findCartByEmailAndCartId(String emailId, Long cartId);
}
