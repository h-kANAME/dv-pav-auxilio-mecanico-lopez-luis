package servicio;

import java.math.BigDecimal;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.Vehiculo;

public class ClienteService {

	public Cliente crearCliente(String nombre, String apellido, String dni, Vehiculo vehiculo, Cobertura cobertura,
			Boolean moroso, BigDecimal costo) {
		return new Cliente(nombre, apellido, dni, vehiculo, cobertura, moroso, costo);
	}

	public BigDecimal aumentoMoroso(Boolean moroso, BigDecimal costo) {
		BigDecimal costoFinal = new BigDecimal(0);
		if (moroso.equals(true)) {
			costoFinal = costo.multiply(new BigDecimal(1.20));
		} else {
			costoFinal = costo;
		}
		return costoFinal;

	}

}
