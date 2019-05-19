package com.paf.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.order.dao.CartDAO;
import com.paf.order.model.Cart;






@RestController
@RequestMapping("/company")
public class CartController {
	CartDAO cartDAO;
	
	/*Save items in to db*/
	@PostMapping("/cart")
	public Cart createCart(@Valid @RequestBody Cart cat) {
		return cartDAO.save(cat);
	}
	
	/*GET ALL items*/
	@GetMapping("/cart")
	public List<Cart>getAllCart(){
		return cartDAO.findAll();
	}
/*get items by a cat id*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable(value="id") Long catid){
		Cart cat=cartDAO.findOne(catid);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cat);
		}
	
	
/*update an rating by ratid*/
@PutMapping("/cart/{id}")
public ResponseEntity<Cart> UpdateCart(@PathVariable(value="id")Long catid,@Valid @RequestBody Cart cartDetails ){
	Cart cat=cartDAO.findOne(catid);
	if(cat==null) {
		return ResponseEntity.notFound().build();
	}
	
    cat.setPro_Id(cartDetails.getPro_Id());
    cat.setItemQuanty(cartDetails.getItemQuanty());
    cat.setDAteAdded(cartDetails.getDAteAdded());
	
	Cart UpdateCart=cartDAO.save(cat);
	return ResponseEntity.ok().body(UpdateCart);
}

/*delete rating*/
@DeleteMapping("/rating/{id}")
public ResponseEntity<Cart> deleteRating(@PathVariable(value="id") Long catid){
	
	Cart cat=cartDAO.findOne(catid);
	if(cat==null) {
		return ResponseEntity.notFound().build();
	}
	cartDAO.delete(cat);
	
	return ResponseEntity.ok().build();
	
	
}
}
