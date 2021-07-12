package dominio;

import java.math.BigDecimal;

public class Pedido {
	
	private String lugar;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private TipoAuxilio tipoAuxilio;
	private Cobertura cobertura;
	private BigDecimal costo;
	
	public Pedido(String lugar, Cliente cliente, TipoAuxilio tipoAuxilio, BigDecimal costo) {
		this.lugar = lugar;
		this.cliente = cliente;
		this.vehiculo = cliente.getVehiculo();
		this.cobertura = cliente.getCobertura();
		this.tipoAuxilio = tipoAuxilio;
		this.costo = costo;
	}

	public Pedido() {

	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public TipoAuxilio getTipoAuxilio() {
		return tipoAuxilio;
	}

	public void setTipoAuxilio(TipoAuxilio tipoAuxilio) {
		this.tipoAuxilio = tipoAuxilio;
	}
	
	public Cobertura getCobertura() {
		return cobertura;
	}
	
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	
	public BigDecimal getCosto() {
		return costo;
	}
	
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}


	@Override
	public String toString() {
		return "Pedido [lugar=" + lugar + ", cliente=" + cliente + ", vehiculo=" + vehiculo + ", tipoAuxilio="
				+ tipoAuxilio + ", cobertura=" + cobertura + ", costo=" + costo + "]";
	}
	
	
	
	
	

}
