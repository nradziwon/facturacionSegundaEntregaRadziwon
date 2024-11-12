package com.coderhouse.modelos;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime fecha = LocalDateTime.now();
	private Double total;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta;
	
	
	public Venta() {
		super();
	}
	

	public Venta(Double total, Cliente cliente, List<DetalleVenta> detallesVenta) {
		super();
		this.total = total;
		this.cliente = cliente;
		this.detallesVenta = detallesVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
}

    
