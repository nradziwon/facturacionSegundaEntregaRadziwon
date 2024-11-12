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

import com.coderhouse.dtos.AsignarVentaDTO;
import com.coderhouse.modelos.Cliente;
import com.coderhouse.servicios.ClienteServicio;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio clienteservicio;
	
	@GetMapping
	public ResponseEntity <List<Cliente>> getAllClientes() {
		try {
			List<Cliente> clientes = clienteservicio.getAllCliente();
			return ResponseEntity.ok(clientes);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
		try {
			Cliente cliente = clienteservicio.findById(id);
			return ResponseEntity.ok(cliente);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente (@RequestBody Cliente cliente){
		try {
			Cliente clienteNuevo = clienteservicio.saveCliente(cliente);
			return ResponseEntity.ok(clienteNuevo);
					
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Cliente> updateClienteById(@PathVariable Long id, @RequestBody Cliente clienteDetalle){
		try {
			Cliente clienteUpdate = clienteservicio.updateCliente(id, clienteDetalle);
			return ResponseEntity.ok(clienteUpdate);	
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> DeleteCliente(@PathVariable Long id){
		
		try {
			clienteservicio.deleteCliente(id);
			return ResponseEntity.noContent().build();
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping("/asignar-venta")
	public ResponseEntity <Cliente> asignarVentaaCliente(@RequestBody AsignarVentaDTO asignarventaDTO){
		try {
			
			Cliente clienteAsignado = clienteservicio.asignarClienteaVenta(asignarventaDTO.getClienteId(), asignarventaDTO.getClienteId());
			return ResponseEntity.ok(clienteAsignado);
			
		}catch(IllegalArgumentException e){
			return  ResponseEntity.notFound().build();			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
	}
	
	
}
