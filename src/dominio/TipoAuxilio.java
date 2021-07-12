package dominio;

import java.math.BigDecimal;

public class TipoAuxilio {

	private String descripion;
	private TipoReparacion tipoReparacion;
	private Boolean requiereRemolque;
	private BigDecimal costoUnitario;
	
	public TipoAuxilio(String descripion) {
		this.descripion = descripion;
	}

	public TipoAuxilio(String descripcion, TipoReparacion tipoReparacion, boolean requiereRemolque,
			BigDecimal costoUnitario) {
		this(descripcion);
		this.tipoReparacion = tipoReparacion;
		this.requiereRemolque = requiereRemolque;
		this.costoUnitario = costoUnitario;	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public TipoReparacion getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoReparacion tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	public Boolean getRequiereRemolque() {
		return requiereRemolque;
	}

	public void setRequiereRemolque(Boolean requiereRemolque) {
		this.requiereRemolque = requiereRemolque;
	}

	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	@Override
	public String toString() {
		return "TipoAuxilio [descripion=" + descripion + ", tipoReparacion=" + tipoReparacion + ", requiereRemolque="
				+ requiereRemolque + ", costoUnitario=" + costoUnitario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripion == null) ? 0 : descripion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAuxilio other = (TipoAuxilio) obj;
		if (descripion == null) {
			if (other.descripion != null)
				return false;
		} else if (!descripion.equals(other.descripion))
			return false;
		return true;
	}
	
	
	
	
	
}
