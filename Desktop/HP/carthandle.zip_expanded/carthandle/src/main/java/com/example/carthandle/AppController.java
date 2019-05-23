package com.example.carthandle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private CartService service;
	
	//Listing order details
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Cart>listCarts =service.listAll();
		model.addAttribute("listCarts",listCarts);
		return "index";
		
	} 
	
	//Creating a new order
	@RequestMapping("/new")
	public String showNewCartForm(Model model) {
		Cart cart =new Cart();
		model.addAttribute("cart",cart);
		return "new_cart";
	}
	
	//Saving added order details
	@RequestMapping(value="/save",method =RequestMethod.POST)
	public String saveCart(@ModelAttribute("cart")Cart cart) {
		service.save(cart);
		return "redirect:/";
	}
	
	//Editing added order details
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCartForm(@PathVariable(name="id")Long id) {
		ModelAndView mav = new ModelAndView("edit_cart");
		Cart cart= service.get(id);
		mav.addObject("cart",cart);
		return mav;
	}
	//Deleting added order details
	@RequestMapping("/delete/{id}")
	public String deleteCart(@PathVariable(name ="id")Long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	
}
