package com.gnvendas.gnVendas.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gnvendas.gnVendas.entities.Produto;
import com.gnvendas.gnVendas.entities.dto.ProdutoDto;
import com.gnvendas.gnVendas.service.CategoriaService;
import com.gnvendas.gnVendas.service.ProdutoService;

@Controller
@RequestMapping(value = "/admin/products")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public String products(Model model) {
		model.addAttribute("products", produtoService.getAllProdutos());
		return "products";
	}
	
	@GetMapping("/add")
	public String getProductsAdd(Model model) {
		model.addAttribute("productDTO", new ProdutoDto());
		model.addAttribute("categories", categoriaService.getAllCategoria());
		return "productsAdd";
	}
	
	@PostMapping("/add")
	public String postProductsAdd(@ModelAttribute("productDTO")ProdutoDto produtoDto){
		Produto produto = new Produto();
		produto.setId(produtoDto.getId());
		produto.setCategoria(categoriaService.getCategoriaById(produtoDto.getCategoryId()).get());
		produto.setDescription(produtoDto.getDescription());
		produto.setName(produtoDto.getName());
		produto.setPrice(produtoDto.getPrice());
		
		produtoService.addProduto(produto);
	
		return "redirect:/admin/products";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		produtoService.removeProdutoById(id);
		return "redirect:/admin/products";
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Produto produto = produtoService.getProductById(id).get();
		ProdutoDto produtoDto = new ProdutoDto();
		produtoDto.setCategoryId(produto.getCategoria().getId());
		produtoDto.setDescription(produto.getDescription());
		produtoDto.setId(produto.getId());
		produto.setName(produto.getName());
		produtoDto.setPrice(produto.getPrice());
		
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("produtoDTO", produtoDto);
		return "productsAdd";
	}
	
}
