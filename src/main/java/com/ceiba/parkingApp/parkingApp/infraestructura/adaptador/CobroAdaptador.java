package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parkingApp.parkingApp.infraestructura.entidad.CobroEntidad;

public interface CobroAdaptador extends CrudRepository<CobroEntidad, Long> {
	List<CobroEntidad> findAll();
}
