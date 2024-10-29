package com.coderhouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cli_id;

    @Column(name = "codigo", unique = true, nullable = false)
    private String cli_codigo;

    @Column(name = "usuario", unique = true, nullable = false)
    private String cli_usuario;

    @Column(name = "dni", unique = true, nullable = false)
    private Long cli_dni;

    @Column(name = "direccion", nullable = false)
    private String cli_direccion;

    @Column(name = "telefono")
    private String cli_telefono;

    @Column(name = "mail")
    private String cli_mail;
    
    // Getters y Setters

	public Long getCli_id() {
		return cli_id;
	}

	public void setCli_id(Long cli_id) {
		this.cli_id = cli_id;
	}

	public String getCli_codigo() {
		return cli_codigo;
	}

	public void setCli_codigo(String cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	public String getCli_usuario() {
		return cli_usuario;
	}

	public void setCli_usuario(String cli_usuario) {
		this.cli_usuario = cli_usuario;
	}

	public Long getCli_dni() {
		return cli_dni;
	}

	public void setCli_dni(Long cli_dni) {
		this.cli_dni = cli_dni;
	}

	public String getCli_direccion() {
		return cli_direccion;
	}

	public void setCli_direccion(String cli_direccion) {
		this.cli_direccion = cli_direccion;
	}

	public String getCli_telefono() {
		return cli_telefono;
	}

	public void setCli_telefono(String cli_telefono) {
		this.cli_telefono = cli_telefono;
	}

	public String getCli_mail() {
		return cli_mail;
	}

	public void setCli_mail(String cli_mail) {
		this.cli_mail = cli_mail;
	}
	
	// toString

	@Override
	public String toString() {
		return "Cliente [cli_id=" + cli_id + ", cli_codigo=" + cli_codigo + ", cli_usuario=" + cli_usuario
				+ ", cli_dni=" + cli_dni + ", cli_direccion=" + cli_direccion + ", cli_telefono=" + cli_telefono
				+ ", cli_mail=" + cli_mail + "]";
	}
}
