package com.upc.entity;

// default package
// Generated 17-may-2018 13:26:54 by Hibernate Tools 5.3.0.Beta2


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Departamento generated by hbm2java
 */
@Entity
@Table(name = "departamento")
public class Departamento  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int iddepartamento;
	
	@ManyToOne
	@JoinColumn(name="idpais")
	private Pais pais;
	private String nombre;
	private String descripcion;

	public Departamento() {
		super();
	}

	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
