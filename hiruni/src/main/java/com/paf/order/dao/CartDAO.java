package com.paf.order.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.order.model.Cart;
import com.paf.order.repo.CartRepo;

@Service
public class CartDAO {
	
	@Autowired
	CartRepo cartRepo;
	
	public Cart save(Cart cat) {
		return cartRepo.save(cat);
		
	}
	
	
	public List<Cart> findAll(){
		return cartRepo.findAll();
	}	

	public Cart findOne(Long catid) {
		return cartRepo.findOne(catid);
		
	}
	
	public void delete(Cart cat) {
		cartRepo.delete(cat);
	}
	

}
