package payment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import payment_project.model.payment;
public interface paymentRepo extends JpaRepository <payment, Long> {

}
