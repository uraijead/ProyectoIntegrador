package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.PagoEntidad;

public interface pagoServicio {

	public List<PagoEntidad> listarTodosLosPagos();
	
	public PagoEntidad guardarPago(PagoEntidad pago);
	
	public PagoEntidad obtenerPago(Long id);
	
	public PagoEntidad actualizarPago(PagoEntidad pago);
	
	public void eliminarPago(Long id);
}
