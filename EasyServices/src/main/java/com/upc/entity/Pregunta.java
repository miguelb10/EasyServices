package com.upc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// default package
// Generated 17-may-2018 13:26:54 by Hibernate Tools 5.3.0.Beta2

/**
 * Pregunta generated by hbm2java
 */
@Entity
@Table(name = "pregunta")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpregunta;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	private String nombre;
	private String motivo;
	private String descripcion;
	private String respuesta;

	public Pregunta() {
		super();
	}

	
	public Integer getIdpregunta() {
		return this.idpregunta;
	}

	public void setIdpregunta(Integer idpregunta) {
		this.idpregunta = idpregunta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
