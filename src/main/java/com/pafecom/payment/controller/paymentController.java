package payment_project.controller;

import java.awt.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import payment_project.Dao.paymentDao;
import payment_project.model.payment;

@RestController
@RequestMapping
public class paymentController {
	@Autowired
	paymentDao paymentdao;
	
	@PostMapping
	public payment createPayment(@Valid @RequestBody payment pay) {
		return paymentdao.save(pay);
		
	}	
	
	@GetMapping
	public List getAllpayments(){
		return paymentdao.findAll();
	}
	public ResponseEntity<payment> getpaymentById(@PathVariable(value="id")Long payid){
		payment pay=paymentdao.findOne(payid);
		
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);
	}
	
	@PutMapping
	public ResponseEntity<payment> updatePayment(@PathVariable(value="id")Long payid,@Valid @RequestBody payment paymentDetails){
		payment pay=paymentdao.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		pay.setCreditCardNumber(paymentDetails.getCreditCardNumber());
		pay.setAmount(paymentDetails.getAmount());
		pay.setCvc(paymentDetails.getCvc());
		pay.setCardHolderName(paymentDetails.getCardHolderName());
		return null;
	}
	@DeleteMapping("/rating/{id}")
	public ResponseEntity<payment> deleteRating(@PathVariable(value="id") Long payid){
		
		payment pay=paymentdao.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		paymentdao.delete(pay);
		
		return ResponseEntity.ok().build();
		
		
	}
}
