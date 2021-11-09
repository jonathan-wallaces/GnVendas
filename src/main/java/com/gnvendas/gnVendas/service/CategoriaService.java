package com.gnvendas.gnVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gnvendas.gnVendas.entities.Categoria;

@Service
public interface CategoriaService {
	
	public void adicionaCategoria(Categoria categoria);
	
	public List<Categoria> getAllCategoria();
	
	public void removeCategoriaById(Long id);
	
	public Optional<Categoria> getCategoriaById(Long id);

}
