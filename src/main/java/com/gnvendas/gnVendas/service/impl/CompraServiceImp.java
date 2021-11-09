package com.gnvendas.gnVendas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gnvendas.gnVendas.entities.Compra;
import com.gnvendas.gnVendas.repositories.CompraRepository;
import com.gnvendas.gnVendas.service.CompraService;

public class CompraServiceImp implements CompraService {

	@Autowired
	private CompraRepository compraRepository;
	@Override
	public void salvarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

}
