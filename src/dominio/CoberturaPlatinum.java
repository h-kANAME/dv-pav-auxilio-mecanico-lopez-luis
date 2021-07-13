package dominio;

public class CoberturaPlatinum extends Cobertura {

	public CoberturaPlatinum(boolean permiteRemolque, Integer limiteRemolque, TipoReparacion tipoReparacion,
			Integer limiteReparacion) {
		super(TipoCobertura.PLATINUM, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

	@Override
	public Boolean permiteRemolque() {

		return true;

	}

	@Override
	public TipoReparacion obtenerTipoDeReparacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
