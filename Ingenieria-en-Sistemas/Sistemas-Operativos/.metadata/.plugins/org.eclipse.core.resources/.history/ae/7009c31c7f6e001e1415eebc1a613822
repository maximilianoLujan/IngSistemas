package BlancanievesSieteEnanitos;

public class Enanito extends Thread{
	private boolean comiendo;
	Casa c1;
	
	public Enanito(boolean comiendo,Casa c1) {
		this.comiendo = comiendo;
		this.c1 = c1;
	}
	
	@Override
	public void run() {
		boolean puedoComer = c1.haySillasLibres();
		if(puedoComer) {
			int sillaOcupada = c1.ocuparSilla();
			System.out.println("El enanito " + Thread.currentThread().getId() + "se sento en la silla " + sillaOcupada);
		} else {
			this.comiendo = false;
			try {
				System.out.println("El enanito " + Thread.currentThread().getId() + " no encontro silla por lo que se fue a trabajar");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
