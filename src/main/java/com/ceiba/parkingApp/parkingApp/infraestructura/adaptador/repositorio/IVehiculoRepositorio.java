package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.VehiculoEntidad;

@Repository
public interface IVehiculoRepositorio extends JpaRepository<VehiculoEntidad, Serializable> {
	//aqui van todos los find
}
