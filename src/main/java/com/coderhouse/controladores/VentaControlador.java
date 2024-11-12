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
import com.coderhouse.modelos.Venta;
import com.coderhouse.servicios.VentaServicio;

@RestController
@RequestMapping("/api/ventas")
public class VentaControlador {
	
	@Autowired
	private VentaServicio ventaservicio;
	
	@GetMapping
	public ResponseEntity <List<Venta>> getAllVentas() {
		try {
			List<Venta> ventas = ventaservicio.getAllVenta();
			return ResponseEntity.ok(ventas);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable Long id){
		try {
			Venta venta = ventaservicio.findById(id);
			return ResponseEntity.ok(venta);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Venta> createVenta (@RequestBody Venta Venta){
		try {
			Venta ventaNuevo = ventaservicio.saveVenta(Venta);
			return ResponseEntity.ok(ventaNuevo);
					
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Venta> updateVentaById(@PathVariable Long id, @RequestBody Venta VentaDetalle){
		try {
			Venta ventaUpdate = ventaservicio.updateVenta(id, VentaDetalle);
			return ResponseEntity.ok(ventaUpdate);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> DeleteVenta(@PathVariable Long id){
		
		try {
			ventaservicio.deleteVenta(id);
			return ResponseEntity.noContent().build();
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	
	
	

}