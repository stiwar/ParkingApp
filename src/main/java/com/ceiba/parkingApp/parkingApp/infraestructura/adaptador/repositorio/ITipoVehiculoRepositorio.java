package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.TipoVehiculoEntidad;

@Repository
public interface ITipoVehiculoRepositorio extends CrudRepository<TipoVehiculoEntidad,Integer>{
	Long countByNombre(String nombre);
}
