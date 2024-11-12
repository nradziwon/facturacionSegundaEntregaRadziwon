package com.coderhouse.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderhouse.modelos.Venta;
import com.coderhouse.repositorios.VentaRepositorio;
import jakarta.transaction.Transactional;

@Service
public class VentaServicio {
	
	@Autowired
	private VentaRepositorio ventarepositorio;
	
	public List<Venta> getAllVenta(){
		return ventarepositorio.findAll();
		
	}
	
	public Venta findById(Long id) {
		return ventarepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Venta no encontrado") );
		
	}
	
	public Venta saveVenta (Venta Venta) {
		return ventarepositorio.save(Venta);
	}
	
	@Transactional
	public Venta updateVenta(Long id, Venta VentaDetalle) {
		
		Venta venta = ventarepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Venta no encontrado"));
		
		venta.setCliente(VentaDetalle.getCliente());
		venta.setTotal(VentaDetalle.getTotal());
		
		
		return ventarepositorio.save(venta);
		/*
		 * como hacer validacion
		 * if(VentaDetalle.getLegajo() !=null){
		 * Venta.setLegajo(VentaDetalle.getLegajo())}
		 * */
	}
	
	public void deleteVenta(Long id) {
		if(!ventarepositorio.existsById(id)) {
			throw new IllegalArgumentException("Venta no encontrado") ;
		}
		ventarepositorio.deleteById(id);
	}
	
	
}
