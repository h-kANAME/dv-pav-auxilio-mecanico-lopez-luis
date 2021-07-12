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
		
		return pedido;
		
	}

}
