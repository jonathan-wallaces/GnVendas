package com.gnvendas.gnVendas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gnvendas.gnVendas.entities.Comprador;
import com.gnvendas.gnVendas.repositories.CompradorRepository;
import com.gnvendas.gnVendas.service.CompradorService;

public class CompradorServiceImp implements CompradorService {
	
	@Autowired
	private CompradorRepository compradorRepository;

	@Override
	public Comprador save(Comprador comprador) {
		return compradorRepository.save(comprador);
	}

}
