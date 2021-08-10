package dominio;

public class CoberturaEconomic extends Cobertura {

	public CoberturaEconomic(boolean permiteRemolque, Integer limiteRemolque, TipoReparacion tipoReparacion,
			Integer limiteReparacion) {
		super(TipoCobertura.ECONOMIC, permiteRemolque, limiteRemolque, tipoReparacion, limiteReparacion);
	}

	@Override
	public Boolean permiteRemolque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TipoReparacion tipoReaparacion() {
		// TODO Auto-generated method stub
		return null;
	}

}