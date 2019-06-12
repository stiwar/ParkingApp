package com.ceiba.parkingApp.parkingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EntityScan(basePackages = {"com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad"})
@SpringBootApplication
public class ParkingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingAppApplication.class, args);
	}

}
