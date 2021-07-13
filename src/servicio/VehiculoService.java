package servicio;

import dominio.Vehiculo;

public class VehiculoService {

	public Vehiculo crearVehiculo(Integer peso, String matricula, Integer cantidadReparaciones, Integer cantidadRemolques) {
		return new Vehiculo(peso, matricula, cantidadRemolques, cantidadRemolques);
	}

}
