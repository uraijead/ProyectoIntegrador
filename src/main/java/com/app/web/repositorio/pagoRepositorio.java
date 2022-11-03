package com.app.web.repositorio;

import com.app.web.entidad.PagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagoRepositorio extends JpaRepository<PagoEntidad, Long>{

}
