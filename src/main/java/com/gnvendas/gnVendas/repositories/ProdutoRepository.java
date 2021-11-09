package com.gnvendas.gnVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnvendas.gnVendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByCategoriaId(Long id);

}
