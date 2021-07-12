package dominio;

public class CoberturaClassic extends Cobertura {

	
	public CoberturaClassic(boolean permiteRemolque, Integer limiteRemolque,
			TipoReparacion tipoReparacion, Integer limiteReparacion) {
		super(TipoCobertura.CLASSIC, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

}
