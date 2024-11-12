package com.coderhouse.apis;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.coderhouse.Interfaces.VendedorRestInterface;
import com.coderhouse.modelos.Vendedor;


@Component
public class VendedorRestApi implements VendedorRestInterface{
	
	private final String BASE_URL = "";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Vendedor> getAllVendedor() {
		try {
			@SuppressWarnings("unchecked")
			List<Vendedor> vendedores = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, List.class ).getBody();
			return vendedores;
			
		}catch(Exception e) {
			
			throw new RuntimeException("Error al obtener los vendedores "+ e.getMessage(), e);
			
		}
		
	}

	@Override
	public Vendedor getVendedorById(String id) {
		try {
			@SuppressWarnings("unchecked")
			String url = BASE_URL + "/" + id;
			return restTemplate.getForObject(url, Vendedor.class);
			
		}catch(Exception e) {
			
			throw new RuntimeException("Error al obtener el vendedor "+ e.getMessage(), e);
			
		}
	}

	@Override
	public Vendedor addVendedor(Vendedor vendedor) {
		try {	
			return restTemplate.postForObject(BASE_URL, vendedor, Vendedor.class);
			
		}catch(Exception e) {
			
			throw new RuntimeException("Error al guardar el vendedor "+ e.getMessage(), e);
			
		}
		
	}

	@Override
	public Vendedor updateVendedor(Vendedor vendedor) {
		try {	
			String url = BASE_URL + "/" + vendedor.getId();
			restTemplate.put(null, vendedor);
			return vendedor;
		}catch(Exception e) {
			
			throw new RuntimeException("Error al modificar el vendedor "+ e.getMessage(), e);
			
		}
	}

	@Override
	public void deleteVendedor(String id) {
		try {	
			String url = BASE_URL + "/" + id;
			restTemplate.delete(url);
	
		}catch(Exception e) {
			
			throw new RuntimeException("Error al eliminar el vendedor "+ e.getMessage(), e);
			
		}
		
	}

}
