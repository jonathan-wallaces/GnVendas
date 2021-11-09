package com.gnvendas.gnVendas.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gnvendas.gnVendas.entities.Produto;
import com.gnvendas.gnVendas.service.ProdutoService;
import com.gnvendas.gnVendas.util.Util;

@Controller
public class CarrinhoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("addToCart/{id}")
	public String addToCart(@PathVariable Long id) {
		Util.cart.add(produtoService.getProductById(id).get());
		return"redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartCount", Util.cart.size());
		model.addAttribute("total", Util.cart.stream()
				.map(Produto::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		model.addAttribute("cart", Util.cart);
		
		return "cart";	
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartProductRemove(@PathVariable int index) {
		Util.cart.remove(index);
		return "redirect:/cart";	
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", Util.cart.stream()
				.map(Produto::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		return "checkout";
	}
	
	

}
