package ProductoresConsumidores;
import java.util.Queue;
import java.util.LinkedList;

public class Cola {
	private Queue<Integer> elementos;
	private int cantidadMaxima;
	
	public Cola(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
		elementos = new LinkedList<Integer>();
	}
	
	public synchronized void addElemento(Integer i) {
		elementos.add(i);
	}
	
	public synchronized int getElemento() {
		return elementos.poll();
	}
	
	public synchronized boolean estaLlena() {
		return elementos.size() >= cantidadMaxima;
	}
	
	public synchronized boolean estaVacia() {
		return elementos.size() == 0;
	}
}
