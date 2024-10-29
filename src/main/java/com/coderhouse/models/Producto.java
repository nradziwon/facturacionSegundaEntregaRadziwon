package com.coderhouse.models;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_id;

    @Column(name = "codigo", unique = true, nullable = false)
    private String prod_codigo;

    @Column(name = "descripcion", nullable = false)
    private String prod_descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal prod_pre_uni;

    @Column(name = "cant_stock", nullable = false)
    private Integer prod_stock;
    
    // Getters y Setters

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_codigo() {
		return prod_codigo;
	}

	public void setProd_codigo(String prod_codigo) {
		this.prod_codigo = prod_codigo;
	}

	public String getProd_descripcion() {
		return prod_descripcion;
	}

	public void setProd_descripcion(String prod_descripcion) {
		this.prod_descripcion = prod_descripcion;
	}

	public BigDecimal getProd_pre_uni() {
		return prod_pre_uni;
	}

	public void setProd_pre_uni(BigDecimal prod_pre_uni) {
		this.prod_pre_uni = prod_pre_uni;
	}

	public Integer getProd_stock() {
		return prod_stock;
	}

	public void setProd_stock(Integer prod_stock) {
		this.prod_stock = prod_stock;
	}
	
	// toString

	@Override
	public String toString() {
		return "Producto [prod_id=" + prod_id + ", prod_codigo=" + prod_codigo + ", prod_descripcion="
				+ prod_descripcion + ", prod_pre_uni=" + prod_pre_uni + ", prod_stock=" + prod_stock + "]";
	}
}
