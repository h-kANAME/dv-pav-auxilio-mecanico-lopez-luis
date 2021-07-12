package servicio;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.Vehiculo;

public class ClienteService {

	public Cliente crearCliente(String nombre, Vehiculo vehiculo, Cobertura cobertura) {
		return new Cliente(nombre, vehiculo, cobertura);
	}

}
