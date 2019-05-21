package com.pafecom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRespository extends JpaRepository<Product, Long>{
	
	List<Product> findAll();

}
