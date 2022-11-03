package com.app.web.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tabla_pagos")
public class PagoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre",nullable = false,length = 20)
	private String nombre;
	
	@Column(name = "totalpago",nullable = false,length = 20)
	private float totalpago;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	@Column(name = "estado",nullable = false,length = 20)
	private String estado;
	
	public PagoEntidad() {

	}


	public PagoEntidad(Long id, String nombre, float totalpago, Date fecha, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.totalpago = totalpago;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public PagoEntidad(String nombre, float totalpago, Date fecha, String estado) {
		super();
		this.nombre = nombre;
		this.totalpago = totalpago;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTotalpago() {
		return totalpago;
	}

	public void setTotalpago(float totalpago) {
		this.totalpago = totalpago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PagoEntidad [id=" + id + ", nombre=" + nombre + ", totalpago=" + totalpago + ", fecha" + fecha + ", estado=" + fecha + "]";
	}
	
	
}
