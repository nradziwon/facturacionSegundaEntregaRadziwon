package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.modelos.Producto;
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
	

}
