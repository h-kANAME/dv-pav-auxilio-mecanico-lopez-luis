package servicio;

import java.math.BigDecimal;

import dominio.Vehiculo;

public class VehiculoService {

	public Vehiculo crearVehiculo(Integer peso, String patente, Integer cantidadDeReparaciones,
			Integer cantidadRemolques) {
		return new Vehiculo(peso, patente, cantidadDeReparaciones, cantidadRemolques);
	}

	public boolean vehiculoPesado(Integer peso) {
		Boolean pesado = null;
		if (peso > 3000) {
			pesado = true;
		} else {
			pesado = false;
		}
		return pesado;
	}

	public BigDecimal aumentoPesado(boolean esPesado, BigDecimal costo) {
		BigDecimal costoFinal = new BigDecimal(0);
		if (esPesado == true) {
			costoFinal = costo.multiply(new BigDecimal(1.10));
		} else {
			costoFinal = costo;
		}
		return costoFinal;

	}

}
