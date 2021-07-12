package dominio;

public class CoberturaEconomic extends Cobertura {
	

	public CoberturaEconomic(boolean permiteRemolque, Integer limiteRemolque,
			TipoReparacion tipoReparacion, Integer limiteReparacion) {
		super(TipoCobertura.ECONOMIC, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

}
