package com.gnvendas.gnVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnvendas.gnVendas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
