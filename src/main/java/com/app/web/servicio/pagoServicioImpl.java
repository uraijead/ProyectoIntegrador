package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.PagoEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.repositorio.pagoRepositorio;

@Service
public class  pagoServicioImpl implements pagoServicio {

	@Autowired
	private pagoRepositorio repositorio;

	@Override
	public List<PagoEntidad> listarTodosLosPagos() {
		return repositorio.findAll();
	}

	@Override
	public PagoEntidad guardarPago(PagoEntidad pago) {
		return repositorio.save(pago);
	}

	@Override
	public PagoEntidad obtenerPago(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public PagoEntidad actualizarPago(PagoEntidad pago) {
		return repositorio.save(pago);
	}

	@Override
	public void eliminarPago(Long id) {
		repositorio.deleteById(id);

	}

}
