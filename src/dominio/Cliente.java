package dominio;

import java.math.BigDecimal;

public class Cliente {

	private String nombre;
	private String apellido;
	private String dni;
	private Vehiculo vehiculo;
	private Cobertura cobertura;

	private Boolean moroso;
	private BigDecimal costo;

	public Cliente(String nombre, String apellido, String dni, Vehiculo vehiculo, Cobertura cobertura, Boolean moroso,
			BigDecimal costo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.vehiculo = vehiculo;
		this.cobertura = cobertura;
		this.moroso = moroso;
		this.costo = costo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public Boolean getMoroso() {
		return moroso;
	}

	public void setMoroso(Boolean moroso) {
		this.moroso = moroso;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", vehiculo=" + vehiculo
				+ ", cobertura=" + cobertura + ", moroso=" + moroso + ", costo=" + costo + "]";
	}

}
