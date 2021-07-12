package servicio;

import dominio.Cobertura;
import dominio.CoberturaEconomic;
import dominio.TipoReparacion;

public class CoberturaService {

	public Cobertura crearCoberturaEconomic() {
		return new CoberturaEconomic(false, 0, TipoReparacion.SIMPLE, 5);
	}

}
