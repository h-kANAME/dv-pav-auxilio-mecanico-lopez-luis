package dominio;

public abstract class Cobertura {

	private TipoCobertura tipoCobertura;
	protected boolean permiteRemolque;
	private Integer limiteRemolque;
	private TipoReparacion tipoReparacion;
	private Integer limiteReparacion;

	protected Cobertura(TipoCobertura tipoCobertura, boolean permiteRemolque, Integer limiteRemolque,
			TipoReparacion tipoReparacion, Integer limiteReparacion) {
		this.tipoCobertura = tipoCobertura;
		this.permiteRemolque = permiteRemolque;
		this.limiteRemolque = limiteRemolque;
		this.tipoReparacion = tipoReparacion;
		this.limiteReparacion = limiteReparacion;
	}

	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public boolean isPermiteRemolque() {
		return permiteRemolque;
	}

	public void setPermiteRemolque(boolean permiteRemolque) {
		this.permiteRemolque = permiteRemolque;
	}

	public Integer getLimiteRemolque() {
		return limiteRemolque;
	}

	public void setLimiteRemolque(Integer limiteRemolque) {
		this.limiteRemolque = limiteRemolque;
	}

	public TipoReparacion getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoReparacion tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	public Integer getLimiteReparacion() {
		return limiteReparacion;
	}

	public void setLimiteReparacion(Integer limiteReparacion) {
		this.limiteReparacion = limiteReparacion;
	}

	public abstract Boolean permiteRemolque();

	public abstract TipoReparacion tipoReaparacion();

	@Override
	public String toString() {
		return "Cobertura [tipoCobertura=" + tipoCobertura + ", permiteRemolque=" + permiteRemolque
				+ ", limiteRemolque=" + limiteRemolque + ", tipoReparacion=" + tipoReparacion + ", limiteReparacion="
				+ limiteReparacion + "]";
	}

}
