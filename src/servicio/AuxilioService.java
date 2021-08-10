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
import Exceptions.NoPermiteReparacion;

public class AuxilioService {

	private Auxilio auxilio;
	private PedidoService pedidoService;
	private TipoAuxilioService tipoAuxilioService;
	private ClienteService clienteService;
	private VehiculoService vehiculoService;
	private CoberturaService coberturaService;

	public AuxilioService(PedidoService pedidoService, TipoAuxilioService tipoAuxilioService,
			ClienteService clienteService, VehiculoService vehiculoService, CoberturaService coberturaService) {
		auxilio = new Auxilio();
		this.pedidoService = pedidoService;
		this.tipoAuxilioService = tipoAuxilioService;
		this.clienteService = clienteService;
		this.vehiculoService = vehiculoService;
		this.coberturaService = new CoberturaService();
		this.auxilio.setAuxilioDisponibles(tipoAuxilioService.tipoAuxiliosDefault());
	}

	public void crearPedido(String lugar, TipoAuxilio tipoAuxilio, String nombreCliente, String apellido, String dni,
			Boolean moroso, BigDecimal costo, Integer pesoVehiculo, TipoCobertura tipoCobertura, String patente,
			Integer cantidadReparaciones, Integer cantidadRemolques) {
		Vehiculo vehiculo = vehiculoService.crearVehiculo(pesoVehiculo, patente, cantidadRemolques,
				cantidadReparaciones);
		Cobertura cobertura = getCoberturaByTipo(tipoCobertura);
		BigDecimal costoFinal = new BigDecimal(0);
		Boolean esPesado = null;
		Boolean permiteReparacion = false;

		costoFinal = clienteService.aumentoMoroso(moroso, costo);
		esPesado = vehiculoService.vehiculoPesado(pesoVehiculo);
		costoFinal = vehiculoService.aumentoPesado(esPesado, costoFinal);

		Cliente cliente = clienteService.crearCliente(nombreCliente, apellido, patente, vehiculo, cobertura, moroso,
				costoFinal);

		Pedido pedido = pedidoService.crearPedido(lugar, cliente, tipoAuxilio);

		try {
			permiteReparacion = coberturaService.permiteReparacion(cobertura, tipoAuxilio, cantidadReparaciones);
		} catch (NoPermiteReparacion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (permiteReparacion == true) {
			auxilio.addPedido(pedido);
			vehiculo.setCantidadReparaciones(cantidadReparaciones + 1);
		}

	}

	protected Cobertura getCoberturaByTipo(TipoCobertura tipoCobertura) {
		Cobertura cobertura = null;
		if (TipoCobertura.ECONOMIC == tipoCobertura) {
			cobertura = coberturaService.crearCoberturaEconomic();
		}
		if (TipoCobertura.CLASSIC == tipoCobertura) {
			cobertura = coberturaService.crearCoberturaClassic(null);
		}
		if (TipoCobertura.PLATINUM == tipoCobertura) {
			cobertura = coberturaService.crearCoberturaPlatinium(null);
		}
		return cobertura;
	}

	public void listarPedidos() {
		System.out.println("Pedidos realizados:");
		for (Pedido pedido : auxilio.getPedidos()) {

			System.out.println(pedido.toString());
		}

	}

	public int listarPedidosPorMorosos() {
		int contador = 0;
		for (Pedido pedido : auxilio.getPedidos()) {
			if (pedido.getCliente().getMoroso().equals(true)) {
				System.out.println(pedido.toString());
				contador++;
			}
		}
		System.out.println("Total clientes morosos: " + contador);
		return contador;

	}

	public void listarTipoAuxilios() {
		System.out.println("Tipos de Auxilio");
		System.out.println("");
		for (TipoAuxilio tipo : auxilio.getAuxilioDisponibles()) {
			System.out.println(tipo);
		}
	}

	public void agregarTipoAuxilio(String descripcion, TipoReparacion tipoReparacion, boolean requiereRemolque,
			BigDecimal costoUnitario) {

		TipoAuxilio auxilioDisponible = tipoAuxilioService.crearTipoAuxilio(descripcion, tipoReparacion,
				requiereRemolque, costoUnitario);
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

	public int pedidosPorTipoAuxilio(TipoAuxilio tipoAuxilio) {
		int contador = 0;
		for (Pedido pedido : auxilio.getPedidos()) {
			if (pedido.getTipoAuxilio().equals(tipoAuxilio)) {
				System.out.println(pedido);
				contador++;

			}

		}
		System.out.println("La cantidad de tipos de auxilio de: " + tipoAuxilio.getDescripion() + " es de: " + contador);
		return contador;
	}

	public int pedidosPorTipoDeCobertura(TipoCobertura tipoCobertura) {
		int contador = 0;
		for (Pedido pedido : auxilio.getPedidos()) {
			if (pedido.getCobertura().getTipoCobertura().equals(tipoCobertura)) {
				contador = contador + 1;
				System.out.println(pedido.toString());
			}
		}
		System.out.println("La cantidad de tipos de cobertura de tipo: " + tipoCobertura + " es de: " + contador);
		return contador;

	}

	public void vehiculosDiferenciadosPorPeso(int peso) {
		int contadorMayores = 0;
		int contadorMenores = 0;
		String menosString = "";
		String masString = "";
		for (Pedido pedido : auxilio.getPedidos()) {
			if (pedido.getVehiculo().getPeso() > peso) {
				contadorMayores = contadorMayores + 1;
				String pesoM = pedido.getVehiculo().getPeso().toString();
				masString = masString + " | " + pesoM + "kg | ";
			}
			if (pedido.getVehiculo().getPeso() < peso) {
				contadorMenores = contadorMenores + 1;
				String pesoMe = pedido.getVehiculo().getPeso().toString();
				menosString = menosString + " | " + pesoMe + "kg | ";
			}
		}
		System.out.println("La cantidad de vehiculos con peso menores a " + peso + " es de: " + contadorMenores
				+ " con un peso de " + menosString + ". La cantidad de vehiculos con peso mayores a " + peso + " es de: "
				+ contadorMayores + " con un peso de " + masString);
	}

	public BigDecimal informarTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Pedido pedido : auxilio.getPedidos()) {
			total = total.add(pedido.getCliente().getCosto());
		}
		System.out.println("Total suma pedidos: ARS " + total);
		return total;
	}

}
