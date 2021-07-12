package servicio;

import dominio.Vehiculo;

public class VehiculoService {

	public Vehiculo crearVehiculo(Integer peso) {
		return new Vehiculo(peso);
	}

}
