package com.coderhouse.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderhouse.modelos.Vendedor;
import com.coderhouse.servicios.VendedorServicio;

@RestController
@RequestMapping("/vendedores")
public class VendedorControlador {
	
	@Autowired
	private VendedorServicio vendedorServicio;

	@GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Vendedor>> getAllVendedor(){
		try {
			List<Vendedor> vendedores = vendedorServicio.getAllVendedor();
			return ResponseEntity.ok(vendedores);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity <Vendedor> getVendedorById(@PathVariable String id){
		try {
			Vendedor vendedor = vendedorServicio.getVendedorById(id);
			return vendedor != null ? ResponseEntity.ok(vendedor) : ResponseEntity.notFound().build();
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PostMapping(value="/", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity <Vendedor> addVendedor(@RequestBody Vendedor vendedor){
		try {
			Vendedor nuevovendedor = vendedorServicio.addVendedor(vendedor);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevovendedor);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping(value="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity <Vendedor> updateVendedor(@PathVariable String id, @RequestBody Vendedor vendedor){
		try {
			vendedor.setId(id);
			Vendedor nuevovendedor = vendedorServicio.updateVendedor(vendedor);
			return ResponseEntity.ok(nuevovendedor);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity <Void> deleteVendedor(@PathVariable String id){
		try {
			vendedorServicio.deleteVendedor(id);
			return ResponseEntity.noContent().build();
			
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	

}
