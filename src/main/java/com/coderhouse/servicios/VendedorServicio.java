package com.coderhouse.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.Interfaces.VendedorRestInterface;
import com.coderhouse.apis.VendedorRestApi;
import com.coderhouse.modelos.Vendedor;


@Service
public class VendedorServicio implements VendedorRestInterface{
	
	@Autowired
	private VendedorRestApi vendedorRestApi;

	@Override
	public List<Vendedor> getAllVendedor() {
		return vendedorRestApi.getAllVendedor();
	}

	@Override
	public Vendedor getVendedorById(String id) {
		return vendedorRestApi.getVendedorById(id);
	}

	@Override
	public Vendedor addVendedor(Vendedor vendedor) {
		return vendedorRestApi.addVendedor(vendedor);
	}

	@Override
	public Vendedor updateVendedor(Vendedor vendedor) {
		return vendedorRestApi.updateVendedor(vendedor);
	}

	@Override
	public void deleteVendedor(String id) {
		vendedorRestApi.deleteVendedor(id);
		
	}

}
