package payment_project.Dao;

import java.awt.List;

import org.springframework.stereotype.Service;

import payment_project.model.payment;
import payment_project.repository.paymentRepo;
@Service
public class paymentDao {

	paymentRepo paymentrepo;
	
	public payment save(payment pay) {
		return paymentrepo.save(pay);
		
	}
	public List findAll(){
		return (List) paymentrepo.findAll();
	}
	
	public payment findOne(Long payid) {
		return paymentrepo.findOne(payid);
	}
	
	public void delete(payment pay) {
		paymentrepo.delete(pay);
	}
}
