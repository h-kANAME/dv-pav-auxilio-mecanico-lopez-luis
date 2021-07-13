package dominio;

public class Vehiculo {

	private Integer peso;
	private String matricula;
	Integer cantidadReparaciones;
	Integer cantidadRemolques;

	public Vehiculo(Integer peso, String matricula, Integer cantidadReparaciones, Integer cantidadRemolques) {
		super();
		this.peso = peso;
		this.matricula = matricula;
		this.cantidadReparaciones = cantidadReparaciones;
		this.cantidadRemolques = cantidadRemolques;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getCantidadReparaciones() {
		return cantidadReparaciones;
	}

	public void setCantidadReparaciones(Integer cantidadReparaciones) {
		this.cantidadReparaciones = cantidadReparaciones;
	}

	public Integer getCantidadRemolques() {
		return cantidadRemolques;
	}

	public void setCantidadRemolques(Integer cantidadRemolques) {
		this.cantidadRemolques = cantidadRemolques;
	}

	@Override
	public String toString() {
		return "Vehiculo [peso=" + peso + ", matricula=" + matricula + ", cantidadReparaciones=" + cantidadReparaciones
				+ ", cantidadRemolques=" + cantidadRemolques + "]";
	}

}
