package RondaDeMate;

public class Tomador extends Thread{
	private boolean estaComiendo;
	private boolean miTurno;
	private Cebador cebador;
	
	
	public Tomador(boolean estaComiendo,Cebador cebador) {
		super();
		this.estaComiendo = estaComiendo;
		this.miTurno = false;
		this.cebador = cebador;
	}
	
	@Override
	public void run() {
		esperarMate();
	}
	
	public synchronized void esperarMate() {
		while(true) {
			while(!miTurno) {
				try {
					System.out.println("El tomador " + Thread.currentThread().getName() + " esta esperando el mate");
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				System.out.println("El tomador " + Thread.currentThread().getName() + " esta tomando el mate");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cebador.termineDeTomar();
			this.miTurno = false;
		}
	}
	
	public synchronized void setTurno() {
		this.miTurno = true;
		this.notify();
	}
}
