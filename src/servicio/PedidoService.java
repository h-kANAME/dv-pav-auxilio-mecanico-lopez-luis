package servicio;

import java.math.BigDecimal;

import dominio.Cliente;
import dominio.Pedido;
import dominio.TipoAuxilio;

public class PedidoService {

	public PedidoService() {

	}

	public Pedido crearPedido(String lugar, Cliente cliente, TipoAuxilio tipoAuxilio) {

		BigDecimal costo = tipoAuxilio.getCostoUnitario();
		Pedido pedido = new Pedido(lugar, cliente, tipoAuxilio, costo);
		BigDecimal costoFinal = new BigDecimal(0);

		if (cliente.getMoroso().equals(true)) {
			costoFinal = costo.multiply(new BigDecimal(1.20));
		} else {
			costoFinal = costo;
		}

		return pedido;

	}

}
