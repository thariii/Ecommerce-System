package com.paf.order.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="shoppingcart")
@EntityListeners(AuditingEntityListener.class )

public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String Pro_Id;
	private int itemQuanty;
	private Date DAteAdded;
	
	
	public Cart() {

		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public String getPro_Id() {
		return Pro_Id;
	}
	public void setPro_Id(String pro_Id) {
		Pro_Id = pro_Id;
	}
	public int getItemQuanty() {
		return itemQuanty;
	}
	public void setItemQuanty(int itemQuanty) {
		this.itemQuanty = itemQuanty;
	}
	public Date getDAteAdded() {
		return DAteAdded;
	}
	public void setDAteAdded(Date dAteAdded) {
		DAteAdded = dAteAdded;
	}
	
	
	
	
	
	
	
}
