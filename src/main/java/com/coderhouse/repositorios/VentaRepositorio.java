package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.modelos.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long>{
	

}

