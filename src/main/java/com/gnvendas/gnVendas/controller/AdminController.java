package com.gnvendas.gnVendas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gnvendas.gnVendas.entities.Categoria;
import com.gnvendas.gnVendas.service.CategoriaService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoriaService.getAllCategoria());
		return "categories";
	}
	
	@GetMapping("/categories/add")
	public String getCategoriesAdd(Model model) {
		model.addAttribute("category", new Categoria());
		return "categoriesAdd";
	}
	
	@PostMapping("/categories/add")
	public String postCategoriesAdd(@ModelAttribute("category") Categoria categoria) {
		categoriaService.adicionaCategoria(categoria);
		return "redirect:/admin/categories";
	}
	//Seria DeleteMapping mas ocorreu erros no front(thymeleaf), por isso utilizei o Get
	@GetMapping("/categories/delete/{id}")
	public String deleteCategorie(@PathVariable Long id) {
		categoriaService.removeCategoriaById(id);
		return "redirect:/admin/categories";
	}
	//Seria PutMapping mas ocorreu erros no front(thymeleaf), por isso utilizei o Get
	@GetMapping("/categories/update/{id}")
	public String updateCategorie(@PathVariable Long id, Model model) {
		Optional<Categoria> categoria = categoriaService.getCategoriaById(id);
		if(categoria.isPresent()) {
			model.addAttribute("category", categoria.get());
			return "categoriesAdd";
		} else
			return "404";
		
	}
	}
