package dominio;

public class CoberturaEconomic extends Cobertura {

	public CoberturaEconomic(boolean permiteRemolque, Integer limiteRemolque, TipoReparacion tipoReparacion,
			Integer limiteReparacion) {
		super(TipoCobertura.ECONOMIC, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

	@Override
	public Boolean permiteRemolque() {
		return false; // nunca se cumple
	}

	@Override
	public TipoReparacion obtenerTipoDeReparacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
