package com.gnvendas.gnVendas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnvendas.gnVendas.entities.Categoria;
import com.gnvendas.gnVendas.repositories.CategoriaRepository;
import com.gnvendas.gnVendas.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void adicionaCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> getAllCategoria() {
		return categoriaRepository.findAll();
	}

	@Override
	public void removeCategoriaById(Long id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<Categoria> getCategoriaById(Long id) {

		return categoriaRepository.findById(id);
	}

}
