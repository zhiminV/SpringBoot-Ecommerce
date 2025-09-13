package com.ecommerce.project.repositories;

import com.ecommerce.project.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.cartId = ?1 AND ci.product.productId = ?2")
    CartItem findCartItemByProductIdAndCartId(Long cartId, Long productId);

    // error : expected select but get delete
    // add Modifying to tell JPA this is to delete
    @Modifying
    @Query("delete FROM CartItem ci WHERE ci.cart.cartId = ?1 and ci.product.productId = ?2")
    void deleteCartItemProductIdAndCartId(Long cartId, Long productId);
}
