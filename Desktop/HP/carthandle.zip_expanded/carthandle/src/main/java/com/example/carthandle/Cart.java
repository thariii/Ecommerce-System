package com.example.carthandle;

//IT17088688-H.P Hiruni Wathsara-WE-IT

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private float price;
	private Long quntity;
	
	
	protected Cart() {
		super();
		
	}
	//Getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getQuntity() {
		return quntity;
	}
	public void setQuntity(Long quntity) {
		this.quntity = quntity;
	}

}
