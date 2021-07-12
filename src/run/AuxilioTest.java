package run;

import java.math.BigDecimal;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.TipoCobertura;
import dominio.TipoReparacion;
import dominio.Vehiculo;
import servicio.AuxilioService;
import servicio.ClienteService;
import servicio.CoberturaService;
import servicio.PedidoService;
import servicio.TipoAuxilioService;
import servicio.VehiculoService;

public class AuxilioTest {
	
	public static void main(String[] args) {
		
		TipoAuxilioService tipoAuxilioService = new TipoAuxilioService();
		PedidoService pedidoService = new PedidoService();
		ClienteService clienteService =  new ClienteService();
		VehiculoService vehiculoService = new VehiculoService();
		CoberturaService coberturaService = new CoberturaService();

		
		AuxilioService auxilioService = new AuxilioService(pedidoService, 
				tipoAuxilioService,
				clienteService,
				vehiculoService,
				coberturaService);
		
		auxilioService.listarTipoAuxilios();
		
		auxilioService.agrerTipoAuxilio("Choque", TipoReparacion.COMPLEJO, true, new BigDecimal(10000));
		
		auxilioService.listarTipoAuxilios();
		

		auxilioService.crearPedido("CABA", auxilioService.getTipoAuxilioPorDescripcion("Pinchadura"), "Pepe", 2000, TipoCobertura.ECONOMIC);
		auxilioService.crearPedido("PBA", auxilioService.getTipoAuxilioPorDescripcion("Choque"), "Toto", 4000, TipoCobertura.PLATINUM);
		
		auxilioService.listarPedidos();
		
		
		
	}
}
