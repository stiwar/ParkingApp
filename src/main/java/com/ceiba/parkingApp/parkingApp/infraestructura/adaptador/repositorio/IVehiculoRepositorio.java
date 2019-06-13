package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.VehiculoEntidad;

@Repository
public interface IVehiculoRepositorio extends CrudRepository<VehiculoEntidad, Integer> {
	@Query("select count(v.id) from VehiculoEntidad v inner join v.tipoVehiculoEntidad tipoVehiculo where tipoVehiculo.id = :idTipoVehiculo")
	public int countVehiculoByIdTipoVehiculo(@Param("idTipoVehiculo") Integer idTipoVehiculo);
	public VehiculoEntidad findById(int idTipoVehiculo);
}
