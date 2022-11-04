package com.app.web.controlador;

import com.app.web.entidad.PagoEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.servicio.pagoServicio;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class pagoControlador {

	@Autowired
	private pagoServicio servicio;

	@GetMapping({ "/pagos", "/" })
	public String listarPagos(Model modelo) {
		modelo.addAttribute("pagos", servicio.listarTodosLosPagos());
		return "pagos";
	}

	@GetMapping("/pagos/nuevo")
	public String mostrarFormularioDeRegistrtarPago(Model modelo) {
		PagoEntidad pagoEntidadOp = new PagoEntidad();
		modelo.addAttribute("pagos", pagoEntidadOp);
		return "crear_pago";
	}

	@PostMapping("/pagos")
	public String guardarPago(@ModelAttribute("pagos") PagoEntidad PagoEntidad) {
		servicio.guardarPago(PagoEntidad);
		return "redirect:/pagos";
	}

	@GetMapping("/pagos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("pagos", servicio.obtenerPago(id));
		return "editar_pago";
	}

	@PostMapping("/pagos/{id}")
	public String actualizarPago(@PathVariable Long id, @ModelAttribute("pagos") PagoEntidad PagoEntidad,
			Model modelo) {
		PagoEntidad pagoExistente = servicio.obtenerPago(id);
		pagoExistente.setId(id);
		pagoExistente.setNombre(PagoEntidad.getNombre());

		pagoExistente.setTotalpago(PagoEntidad.getTotalpago());
		pagoExistente.setEstado(PagoEntidad.getEstado());

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		java.sql.Timestamp  timestamp = java.sql.Timestamp.valueOf(timeStamp);

		pagoExistente.setFecha(timestamp);

		servicio.actualizarPago(pagoExistente);
		return "redirect:/pagos";
	}

	@GetMapping("/PagoEntidad/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarPago(id);
		return "redirect:/pagos";
	}
}
