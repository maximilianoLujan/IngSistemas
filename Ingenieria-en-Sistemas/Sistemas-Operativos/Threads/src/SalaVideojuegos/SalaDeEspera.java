package SalaVideojuegos;

import java.util.Queue;
import java.util.LinkedList;

public class SalaDeEspera {
	private boolean estanJugando;
	private Queue<Jugador> jugadoresEsperando;
	private Queue<Jugador> jugadoresJugando;
	private static final int minimoJugadores = 4;
	
	public SalaDeEspera() {
		this.estanJugando = false;
		this.jugadoresEsperando = new LinkedList<Jugador>();
		this.jugadoresJugando = new LinkedList<Jugador>();
	}
	
	public synchronized void addJugador(Jugador j1) {
		jugadoresEsperando.add(j1);
	}
	
	public synchronized void addJugadorJugando(Jugador j1) {
		jugadoresEsperando.add(j1);
	}
	
	public synchronized boolean sePuedeJugar() {
		if(this.jugadoresEsperando.size() >= 4) {
			return true;
		}
		return false;
	}
	
	public synchronized boolean hayAlguienJugando() {
		return this.estanJugando;
	}
	
	public synchronized void jugar(Jugador j1) {
		this.estanJugando = true;
		System.out.println("El jugador esta jugando ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jugadoresJugando.remove(j1);
		this.estanJugando = false;
		this.seLiberoJuego();
	}
	
	public synchronized void seLiberoJuego() {
		jugadoresJugando.forEach(jugador -> jugador.notify());
	}
}
