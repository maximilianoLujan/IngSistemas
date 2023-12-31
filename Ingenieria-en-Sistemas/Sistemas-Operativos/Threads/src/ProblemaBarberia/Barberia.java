package ProblemaBarberia;
import java.util.Queue;
import java.util.LinkedList;

public class Barberia {
	int maxSillas;
	boolean barberoAtendiendo;
	Barbero barbero;
	Queue<Cliente> clientesEsperando;
	
	public Barberia(int sillasSalas) {
		maxSillas = sillasSalas;
		clientesEsperando = new LinkedList<Cliente>();
		barbero = null;
		barberoAtendiendo = false;
	}
	
	public void setBarbero(Barbero b1) {
		this.barbero = b1;
	}
	
	public boolean hayAsientoLibre() {
		return clientesEsperando.size() < maxSillas;
	}
	
	public synchronized void tomarAsiento(Cliente c1) {
		clientesEsperando.offer(c1);
		System.out.println("Cliente " + c1.name + "espera en la barberia"); 
		System.out.println("[" + Thread.currentThread().getName() + " ] sillasOcupadas " + clientesEsperando.size() + "/" + maxSillas);
		if(clientesEsperando.size() == 1 && !barberoAtendiendo) {
			barbero.despertar();
		}
	}
	
	public synchronized Cliente proximoCliente() {
		Cliente next = clientesEsperando.poll();
		barberoAtendiendo = next != null ?true :false;
		System.out.println("[" + Thread.currentThread().getName() + " ] sillasOcupadas " + clientesEsperando.size() + "/" + maxSillas);
		return next;
	}
}
