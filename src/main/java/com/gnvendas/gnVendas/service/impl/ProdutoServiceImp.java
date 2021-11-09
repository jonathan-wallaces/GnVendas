package com.gnvendas.gnVendas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnvendas.gnVendas.entities.Produto;
import com.gnvendas.gnVendas.repositories.ProdutoRepository;
import com.gnvendas.gnVendas.service.ProdutoService;

@Service
public class ProdutoServiceImp implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void addProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public void removeProdutoById(Long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public Optional<Produto> getProductById(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public List<Produto> getAllProdutoByCategoriaId(Long id) {
		return produtoRepository.findAllByCategoriaId(id);
	}
	
	

}
