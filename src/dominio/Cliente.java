package dominio;

public class Cliente {
	
	private String nombre;
	
	private Vehiculo vehiculo;
	
	private Cobertura cobertura;
	

	public Cliente(String nombre, Vehiculo vehiculo, Cobertura cobertura) {
		this.nombre = nombre;
		this.vehiculo = vehiculo;
		this.cobertura = cobertura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", vehiculo=" + vehiculo + ", cobertura=" + cobertura + "]";
	}

}
