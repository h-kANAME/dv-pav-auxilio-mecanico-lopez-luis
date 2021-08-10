package run;

import java.math.BigDecimal;

import dominio.Cliente;
import dominio.Cobertura;
import dominio.TipoAuxilio;
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
		ClienteService clienteService = new ClienteService();
		VehiculoService vehiculoService = new VehiculoService();
		CoberturaService coberturaService = new CoberturaService();

		AuxilioService auxilioService = new AuxilioService(pedidoService, tipoAuxilioService, clienteService,
				vehiculoService, coberturaService);

		auxilioService.agregarTipoAuxilio("Rotura de Parabrisas", TipoReparacion.COMPLEJO, true, new BigDecimal(15000));

		auxilioService.listarTipoAuxilios();
		System.out.println("");

		System.out.println("Forzando Exception:");
		
		auxilioService.crearPedido("Belgrano", auxilioService.getTipoAuxilioPorDescripcion("Pinchadura"), "Emmanuel",
				"Lopez", "35233665", false, new BigDecimal(15000), 4000, TipoCobertura.PLATINUM, "AB806AX", 0, 0);

		auxilioService.crearPedido("Glew", auxilioService.getTipoAuxilioPorDescripcion("Rotura de Parabrisas"),
				"Guadalupe", "Basso", "100097931", true, new BigDecimal(15000), 15000, TipoCobertura.ECONOMIC,
				"AD025DD", 0, 0);
		auxilioService.crearPedido("Berazategui", auxilioService.getTipoAuxilioPorDescripcion("Bateria"), "Damian",
				"Jorgelino", "24526351", true, new BigDecimal(28600), 2500, TipoCobertura.ECONOMIC, "UST654", 0, 0);
		auxilioService.crearPedido("Carmet", auxilioService.getTipoAuxilioPorDescripcion("Bateria"), "Jorge", "Rivero",
				"34533751", true, new BigDecimal(28600), 5000, TipoCobertura.CLASSIC, "BTC654", 0, 0);
		System.out.println("");

		System.out.println("Caso de prueba N°1 - Cliente moroso que solicito un pedido");
		auxilioService.listarPedidosPorMorosos();
		System.out.println("");

		System.out.println("Caso de prueba N°2 - Pedidos solicitados por TIPO DE AUXILIO ");
		auxilioService.pedidosPorTipoAuxilio(auxilioService.getTipoAuxilioPorDescripcion("Pinchadura"));
		System.out.println("");

		auxilioService.pedidosPorTipoAuxilio(auxilioService.getTipoAuxilioPorDescripcion("Bateria"));
		System.out.println("");

		// auxilioService.pedidosPorTipoAuxilio(auxilioService.getTipoAuxilioPorDescripcion("Rotura
		// de Parabrisas"));
		// System.out.println("");

		// auxilioService.listarPedidos();
		// System.out.println("");

		System.out.println("Caso de prueba N°3 - Pedidos solicitados por TIPO DE COBERTURA ");
		auxilioService.pedidosPorTipoDeCobertura(TipoCobertura.ECONOMIC);
		System.out.println("");

		auxilioService.pedidosPorTipoDeCobertura(TipoCobertura.CLASSIC);
		System.out.println("");

		auxilioService.pedidosPorTipoDeCobertura(TipoCobertura.PLATINUM);
		System.out.println("");

		System.out.println("Caso de prueba N°4 - Vehiculos atendidos por peso");
		auxilioService.vehiculosDiferenciadosPorPeso(3000);
		System.out.println("");

		System.out.println("Caso de prueba N°5 - Suma costo pedidos");
		auxilioService.informarTotal();
		System.out.println("");

	}
}