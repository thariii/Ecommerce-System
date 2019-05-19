package com.paf.order.repo;


import com.paf.order.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CartRepo extends JpaRepository<Cart, Long> {
	

}