package com.coderhouse.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.modelos.Cliente;
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	

}
