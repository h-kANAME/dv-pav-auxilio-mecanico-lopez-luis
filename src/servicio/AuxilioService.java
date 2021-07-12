package servicio;



import java.math.BigDecimal;

import dominio.Auxilio;
import dominio.Cliente;
import dominio.Cobertura;
import dominio.Pedido;
import dominio.TipoAuxilio;
import dominio.TipoCobertura;
import dominio.TipoReparacion;
import dominio.Vehiculo;

public class AuxilioService {
	
	private Auxilio auxilio;
	private PedidoService pedidoService;
	private TipoAuxilioService tipoAuxilioService;
	private ClienteService clienteService;
	private VehiculoService vehiculoService;
	private CoberturaService coberturaService;
	
	
	public AuxilioService(PedidoService pedidoService, 
			TipoAuxilioService tipoAuxilioService, 
			ClienteService clienteService,
			VehiculoService vehiculoService,
			CoberturaService coberturaService) {	
		auxilio = new Auxilio();
		this.pedidoService = pedidoService;
		this.tipoAuxilioService = tipoAuxilioService;
		this.clienteService = clienteService;
		this.vehiculoService = vehiculoService;
		this.coberturaService = new CoberturaService();
		this.auxilio.setAuxilioDisponibles(tipoAuxilioService.tipoAuxiliosDefault());
	}
	
	public void crearPedido(String lugar, TipoAuxilio tipoAuxilio, String nombreCliente, Integer pesoVehiculo, TipoCobertura tipoCobertura) {
		Vehiculo vehiculo = vehiculoService.crearVehiculo(pesoVehiculo);
		Cobertura cobertura = getCoberturaByTipo(tipoCobertura);
		Cliente cliente = clienteService.crearCliente(nombreCliente, vehiculo, cobertura);

		Pedido pedido = pedidoService.crearPedido(lugar, cliente, tipoAuxilio);
		auxilio.addPedido(pedido);
	}

	protected Cobertura getCoberturaByTipo(TipoCobertura tipoCobertura) {
		Cobertura cobertura = null;
		if (TipoCobertura.ECONOMIC == tipoCobertura) {
			cobertura = coberturaService.crearCoberturaEconomic();
		}
		return cobertura;
	}

	
	public void listarPedidos() {
		System.out.println("LISTADO DE PEDIDOS");		
		for (Pedido pedido : auxilio.getPedidos()) {
			
			System.out.println(pedido.toString());
		}
		
	}
	
	public void listarTipoAuxilios() {
		System.out.println("LISTADO DE TIPOS DE AUXILIOS");
		for (TipoAuxilio tipo : auxilio.getAuxilioDisponibles()) {
			System.out.println(tipo);
		}
	}

	public void agrerTipoAuxilio(String descripcion, TipoReparacion tipoReparacion, boolean requiereRemolque, BigDecimal costoUnitario) {
		
		TipoAuxilio auxilioDisponible = tipoAuxilioService.crearTipoAuxilio(descripcion, tipoReparacion, requiereRemolque, costoUnitario); 
		auxilio.addAuxilioDisponible(auxilioDisponible);
		
	}

	public TipoAuxilio getTipoAuxilioPorDescripcion(String descripcion) {
		TipoAuxilio tipoAuxilioABuscar = new TipoAuxilio(descripcion);
		if (auxilio.getAuxilioDisponibles().contains(tipoAuxilioABuscar)) {
			Integer index = auxilio.getAuxilioDisponibles().indexOf(tipoAuxilioABuscar);
			tipoAuxilioABuscar = auxilio.getAuxilioDisponibles().get(index);
		}
		// si no existe se debe lanzar una excption
		return tipoAuxilioABuscar;
	}

}
