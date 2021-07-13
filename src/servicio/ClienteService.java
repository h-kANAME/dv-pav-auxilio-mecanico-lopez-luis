package servicio;

import java.math.BigDecimal;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.Vehiculo;

public class ClienteService {

	public Cliente crearCliente(String nombre, String apellido, String dni, Vehiculo vehiculo, Cobertura cobertura, Boolean moroso,
			BigDecimal costo) {
		return new Cliente(nombre, apellido, dni, vehiculo, cobertura, moroso, costo);
	}

}
