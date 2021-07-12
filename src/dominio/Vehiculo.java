package dominio;

public class Vehiculo {
	
	private Integer peso;

	public Vehiculo(Integer peso) {
		this.peso = peso;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Vehiculo [peso=" + peso + "]";
	}
	
	

}
