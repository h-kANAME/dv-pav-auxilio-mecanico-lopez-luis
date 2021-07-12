package dominio;

public class CoberturaPlatinum extends Cobertura {
	

	
	public CoberturaPlatinum(boolean permiteRemolque, Integer limiteRemolque,
			TipoReparacion tipoReparacion, Integer limiteReparacion) {
		super(TipoCobertura.PLATINUM, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

}
