package SalaVideojuegos;

public class Jugador extends Thread{
	private boolean jugando;
	private SalaDeEspera sala;
	
	public Jugador(boolean jugando,SalaDeEspera sala) {
		this.jugando = jugando;
		this.sala = sala;
	}
	
	@Override
	public void run() {
		synchronized(this) {
			try {
				System.out.println("El jugador " + Thread.currentThread().getName() + " llego a la cola de espera");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(!sala.sePuedeJugar()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("El jugador " + Thread.currentThread().getName() + " ya esta en la sala para jugar");
			sala.addJugadorJugando(this);
			while(!sala.hayAlguienJugando()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sala.jugar(this);
			
		}
	}
	

}
