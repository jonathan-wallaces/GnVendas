package com.gnvendas.gnVendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gnvendas.gnVendas.service.CategoriaService;
import com.gnvendas.gnVendas.service.ProdutoService;

@Controller
public class HomeController {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("products", produtoService.getAllProdutos());
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable Long id) {
		model.addAttribute("produto", produtoService.getProductById(id).get());
		return "viewProduct";
	}
}
