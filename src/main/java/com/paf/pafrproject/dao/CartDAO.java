package com.paf.pafrproject.dao;


import java.util.List;



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
