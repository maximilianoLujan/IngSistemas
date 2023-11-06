package RondaDeMate;

public class Cebador extends Thread {
	private RondaDeMates ronda;
	private boolean estanTomando;
	
	
	public Cebador(RondaDeMates ronda) {
		this.ronda = ronda;
		this.estanTomando = false;
	}
	
	
	@Override 
	public void run() {
		cebarMates();
	}
	
	public synchronized void cebarMates() {
		while(true) {
			while(estanTomando) {
				try {
					System.out.println("El cebador " + Thread.currentThread().getName() + " esta esperando que tomen el mate");
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ronda.getCantidadCebadas() == 0) {
				System.out.println("No hay mas agua, el cebador va a recargar");
				try {
					ronda.recargarCebadas();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Tomador tomador = ronda.obtenerSiguiente();
			tomador.setTurno();
			this.estanTomando = true;
		}
	}
	
	public synchronized void termineDeTomar() {
		ronda.restarCebada();
		System.out.println("Quedan " + ronda.getCantidadCebadas() + " cebadas");
		this.estanTomando = false;
		this.notify();
	}
}
