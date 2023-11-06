package RondaDeMate;

import java.util.ArrayList;

public class RondaDeMates {
	private ArrayList<Tomador> amigos;
	private int amigoTomando;
	private int cebadasDisponibles;
	
	
	public RondaDeMates(int cebadasDisponibles) {
		this.amigos = new ArrayList<Tomador>();
		this.amigoTomando = -1;
		this.cebadasDisponibles = cebadasDisponibles;
	}
	
	public synchronized Tomador obtenerSiguiente() {
		if(this.amigoTomando == -1) {
			this.amigoTomando = 0;
			return amigos.get(0);
		} else {
			int siguiente = this.amigoTomando + 1;
			if (siguiente >= amigos.size()) {
				this.amigoTomando = 0;
				return amigos.get(0);
			}
			this.amigoTomando = siguiente;
			return amigos.get(siguiente);
		}
	}
	
	public void addTomador(Tomador t1) {
		this.amigos.add(t1);
	}
	
	public synchronized void restarCebada() {
		this.cebadasDisponibles--;
	}
	
	public synchronized int getCantidadCebadas() {
		return this.cebadasDisponibles;
	}
	
	public synchronized void recargarCebadas() {
		this.cebadasDisponibles = 20;
	}
}
