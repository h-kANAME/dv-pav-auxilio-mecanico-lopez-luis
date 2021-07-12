package dominio;

import java.util.ArrayList;
import java.util.List;

public class Auxilio {
	
	private List<Pedido> pedidos;
	private List<TipoAuxilio> auxilioDisponibles;
	

	public Auxilio() {
		pedidos = new ArrayList<Pedido>();
		auxilioDisponibles = new ArrayList<TipoAuxilio>();
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public List<TipoAuxilio> getAuxilioDisponibles() {
		return auxilioDisponibles;
	}
	
	public void setAuxilioDisponibles(List<TipoAuxilio> auxilioDisponibles) {
		this.auxilioDisponibles = auxilioDisponibles;
	}
	
	public void addAuxilioDisponible(TipoAuxilio auxilioDisponible) {
		this.auxilioDisponibles.add(auxilioDisponible);
	}

	@Override
	public String toString() {
		return "Auxilio [pedidos=" + pedidos + ", auxilioDisponibles=" + auxilioDisponibles + "]";
	}
	
		
	

}
