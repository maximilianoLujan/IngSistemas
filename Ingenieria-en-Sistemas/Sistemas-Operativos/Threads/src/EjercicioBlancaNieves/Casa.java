package EjercicioBlancaNieves;

public class Casa {
	int maximoSillas;
	int sillasOcupadas;
	
	
	public Casa(int maximoSillas) {
		this.maximoSillas = maximoSillas;
		this.sillasOcupadas = 0;
	}
	
	public synchronized void ocuparSilla() throws InterruptedException {
		if (sillasOcupadas == maximoSillas) {
			System.out.println("Las sillas estan ocupadas " + Thread.currentThread().getName());
			wait();
		}
		sillasOcupadas++;
	}
	
	public synchronized void desocuparSilla() {
		System.out.println("El enanito " + Thread.currentThread().getName() + "desocupo una silla");
		notifyAll();
		sillasOcupadas--;
	}
	
	public int getSillasOcupadas() {
		return this.sillasOcupadas;
	}
}
