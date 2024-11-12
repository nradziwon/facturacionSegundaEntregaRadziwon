package com.coderhouse.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderhouse.modelos.Producto;
import com.coderhouse.repositorios.ProductoRepositorio;
import jakarta.transaction.Transactional;

@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio productorepositorio;
	
	public List<Producto> getAllProducto(){
		return productorepositorio.findAll();
		
	}
	
	public Producto findById(Long id) {
		return productorepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado") );
		
	}
	
	public Producto saveProducto (Producto Producto) {
		return productorepositorio.save(Producto);
	}
	
	@Transactional
	public Producto updateProducto(Long id, Producto productoDetalle) {
		
		Producto producto = productorepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		
		producto.setNombre(productoDetalle.getNombre());
		producto.setDescripcion(productoDetalle.getDescripcion());
		producto.setPrecioUnitario(productoDetalle.getPrecioUnitario());
		producto.setStock(productoDetalle.getStock());
		
		return productorepositorio.save(producto);
		/*
		 * como hacer validacion
		 * if(ProductoDetalle.getLegajo() !=null){
		 * Producto.setLegajo(ProductoDetalle.getLegajo())}
		 * */
	}
	
	public void deleteProducto(Long id) {
		if(!productorepositorio.existsById(id)) {
			throw new IllegalArgumentException("Producto no encontrado") ;
		}
		productorepositorio.deleteById(id);
	}

}
