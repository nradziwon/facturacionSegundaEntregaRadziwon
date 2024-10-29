package com.coderhouse.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ven_id;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente ven_cliente;

    @Column(name = "total", nullable = false)
    private BigDecimal ven_total;

    private LocalDateTime ven_fecha = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "venta_producto",
        joinColumns = @JoinColumn(name = "venta_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos = new ArrayList<>();
    
    // Getters y Setters

	public Long getVen_id() {
		return ven_id;
	}

	public void setVen_id(Long ven_id) {
		this.ven_id = ven_id;
	}

	public Cliente getVen_cliente() {
		return ven_cliente;
	}

	public void setVen_cliente(Cliente ven_cliente) {
		this.ven_cliente = ven_cliente;
	}

	public BigDecimal getVen_total() {
		return ven_total;
	}

	public void setVen_total(BigDecimal ven_total) {
		this.ven_total = ven_total;
	}

	public LocalDateTime getVen_fecha() {
		return ven_fecha;
	}

	public void setVen_fecha(LocalDateTime ven_fecha) {
		this.ven_fecha = ven_fecha;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	// toString
	
	@Override
	public String toString() {
		return "Venta [ven_id=" + ven_id + ", ven_cliente=" + ven_cliente + ", ven_total=" + ven_total + ", ven_fecha="
				+ ven_fecha + ", productos=" + productos + "]";
	}   
}
