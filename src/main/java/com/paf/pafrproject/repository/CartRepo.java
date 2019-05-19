package com.paf.pafrproject.repository;

import com.paf.order.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CartRepo extends JpaRepository<Cart, Long> {
	

}
