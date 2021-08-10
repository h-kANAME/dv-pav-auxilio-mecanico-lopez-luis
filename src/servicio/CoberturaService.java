package servicio;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.CoberturaClassic;
import dominio.CoberturaEconomic;
import dominio.CoberturaPlatinum;
import dominio.TipoAuxilio;
import dominio.TipoCobertura;
import dominio.TipoReparacion;
import Exceptions.NoPermiteReparacion;

public class CoberturaService {

	Integer infinito = Integer.MAX_VALUE;

	public Cobertura crearCoberturaEconomic() {
		return new CoberturaEconomic(false, 0, TipoReparacion.SIMPLE, 5);
	}

	public Cobertura crearCoberturaClassic(Cliente cliente) {
		return new CoberturaClassic(true, 5, TipoReparacion.COMPLEJO, this.infinito);
	}

	public Cobertura crearCoberturaPlatinium(Cliente cliente) {
		return new CoberturaPlatinum(true, this.infinito, TipoReparacion.COMPLEJO, this.infinito);
	}

	public Boolean permiteReparacion(Cobertura cobertura, TipoAuxilio tipoAuxilio, Integer cantidadReparaciones)
			throws NoPermiteReparacion {
		Boolean permiteReparacion;

		if (tipoAuxilio.getRequiereRemolque().equals(true)
				&& cobertura.getTipoCobertura().equals(TipoCobertura.ECONOMIC)) {
			permiteReparacion = false;
			throw new NoPermiteReparacion("La cobertura Economic no permite pedidos de auxilio con remolque");
		}
		if (cobertura.getTipoCobertura().equals(TipoCobertura.ECONOMIC) & cantidadReparaciones >= 5
				|| cobertura.getTipoCobertura().equals(TipoCobertura.ECONOMIC)
						&& cobertura.getTipoReparacion().equals(TipoReparacion.COMPLEJO)) {
			permiteReparacion = false;
			throw new NoPermiteReparacion(
					"La cobertura Economic no permite mas de 5 reparaciones, ni reparaciones complejas");
		} else {
			permiteReparacion = true;
		}

		return permiteReparacion;
	}

}