package com.gnvendas.gnVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gnvendas.gnVendas.entities.Produto;
@Service
public interface ProdutoService {
	
	void addProduto(Produto produto);
	void removeProdutoById (Long id);

	List<Produto> getAllProdutos();
	
	Optional<Produto> getProductById(Long id);
	
	List<Produto> getAllProdutoByCategoriaId(Long id);

}
