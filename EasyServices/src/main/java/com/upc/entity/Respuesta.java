package com.upc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idrespuesta;
	
	@ManyToOne
	@JoinColumn(name="idpregunta")
	private Pregunta pregunta;
	private String nombre;
	private String descripcion;
	private String extra;

	public Respuesta() {
		super();
	}
	
	public Integer getIdrespuesta() {
		return idrespuesta;
	}

	public void setIdrespuesta(Integer idrespuesta) {
		this.idrespuesta = idrespuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

}
