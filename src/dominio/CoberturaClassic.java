package dominio;

public class CoberturaClassic extends Cobertura {

	public CoberturaClassic(boolean permiteRemolque, Integer limiteRemolque, TipoReparacion tipoReparacion,
			Integer limiteReparacion) {
		super(TipoCobertura.CLASSIC, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

	@Override
	public TipoReparacion tipoReaparacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean permiteRemolque() {
		// TODO Auto-generated method stub
		return null;
	}

}
