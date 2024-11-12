package com.coderhouse.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.modelos.Cliente;
import com.coderhouse.modelos.Producto;
import com.coderhouse.repositorios.ProductoRepositorio;
import com.coderhouse.servicios.ClienteServicio;
import com.coderhouse.servicios.ProductoServicio;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoservicio;
	
	@GetMapping
	public ResponseEntity <List<Producto>> getAllProducto() {
		try {
			List<Producto> producto = productoservicio.getAllProducto();
			return ResponseEntity.ok(producto);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
		try {
			Producto producto = productoservicio.findById(id);
			return ResponseEntity.ok(producto);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Producto> createProducto (@RequestBody Producto producto){
		try {
			Producto productoNuevo = productoservicio.saveProducto(producto);
			return ResponseEntity.ok(productoNuevo);
					
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Producto> updateProductoById(@PathVariable Long id, @RequestBody Producto productoDetalle){
		try {
			Producto productoUpdate = productoservicio.updateProducto(id, productoDetalle);
			return ResponseEntity.ok(productoUpdate);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> DeleteProducto(@PathVariable Long id){
		
		try {
			productoservicio.deleteProducto(id);
			return ResponseEntity.noContent().build();
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	
	
	

}
