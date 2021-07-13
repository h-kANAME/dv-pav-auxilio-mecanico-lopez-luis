package servicio;

import dominio.Cobertura;
import dominio.CoberturaClassic;
import dominio.CoberturaEconomic;
import dominio.CoberturaPlatinum;
import dominio.TipoReparacion;

public class CoberturaService {

	// Double unlimited = Double.POSITIVE_INFINITY;
	// Fuente infinito
	// https://www.iteramos.com/pregunta/35415/como-implementar-el-infinito-en-java

	Integer unlimited = Integer.MAX_VALUE;
	// Fuente maximo integer
	// https://qastack.mx/programming/12952024/how-to-implement-infinity-in-java

	public Cobertura crearCoberturaEconomic() {
		return new CoberturaEconomic(false, 0, TipoReparacion.SIMPLE, 5);
		// permiteRemolque, limiteRemolque, TipoReparacion, limiteReparacion
	}

	public Cobertura crearCoberturaClassic() {
		return new CoberturaClassic(true, 5, TipoReparacion.ILIMITADO, this.unlimited);
	}

	public Cobertura crearCoberturaPlatinum() {

		return new CoberturaPlatinum(true, this.unlimited, TipoReparacion.ILIMITADO, this.unlimited);
	}

}
