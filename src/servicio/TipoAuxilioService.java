package servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dominio.TipoAuxilio;
import dominio.TipoReparacion;

public class TipoAuxilioService {

	public TipoAuxilioService() {
	}

	public TipoAuxilio crearTipoAuxilio(String descripcion, TipoReparacion tipoReparacion, boolean requiereRemolque,
			BigDecimal costoUnitario) {
		TipoAuxilio tipoAuxilio = new TipoAuxilio(descripcion, tipoReparacion, requiereRemolque, costoUnitario);
		return tipoAuxilio;
	}

	public TipoAuxilio pinchadura() {
		return crearTipoAuxilio("Pinchadura", TipoReparacion.SIMPLE, false, new BigDecimal(100));
	}

	public TipoAuxilio bateria() {
		return crearTipoAuxilio("Bateria", TipoReparacion.SIMPLE, false, new BigDecimal(150));
	}

	public List<TipoAuxilio> tipoAuxiliosDefault() {
		List<TipoAuxilio> tipoAuxilios = new ArrayList<TipoAuxilio>();

		tipoAuxilios.add(pinchadura());
		tipoAuxilios.add(bateria());

		return tipoAuxilios;
	}

}
