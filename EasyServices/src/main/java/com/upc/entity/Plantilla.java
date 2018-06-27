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
 * Plantilla generated by hbm2java
 */
@Entity
@Table(name = "plantilla")
public class Plantilla {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idplantilla;
	
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="idsolicitud")
	private EstadoValidar estadoValidar;
	
	@ManyToOne
	@JoinColumn(name="idlista_sucursal")
	private ListaSucursal listaSucursal;
	
	@ManyToOne
	@JoinColumn(name="idestado_validar")
	private EstadoValidar estadoValidar;


	@JoinColumn(name="idservicio")
	private Servicio servicio;

	
	private String descripcion;


	public Plantilla() {
		super();
	}



	public Integer getIdplantilla() {
		return this.idplantilla;
	}

	public void setIdplantilla(Integer idplantilla) {
		this.idplantilla = idplantilla;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EstadoValidar getEstadoValidar() {
		return this.estadoValidar;
	}

	public void setEstadoValidar(EstadoValidar estadoValidar) {
		this.estadoValidar = estadoValidar;
	}

	public ListaSucursal getListaSucursal() {
		return this.listaSucursal;
	}

	public void setListaSucursal(ListaSucursal listaSucursal) {
		this.listaSucursal = listaSucursal;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
