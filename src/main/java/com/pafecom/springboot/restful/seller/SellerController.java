package com.pafecom.springboot.restful.seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {

	 @GetMapping("/")
	    public String list(){
	        return "sellers";
	    }
}
