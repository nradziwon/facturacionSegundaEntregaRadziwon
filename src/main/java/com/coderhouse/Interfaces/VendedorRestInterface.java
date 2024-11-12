package com.coderhouse.Interfaces;

import java.util.List;

import com.coderhouse.modelos.Vendedor;

public interface VendedorRestInterface {
	
	public List<Vendedor> getAllVendedor();
	
	public Vendedor getVendedorById(String id);
	
	public Vendedor addVendedor(Vendedor vendedor);
	
	public Vendedor updateVendedor (Vendedor vendedor);
	
	public void deleteVendedor (String id);

}
