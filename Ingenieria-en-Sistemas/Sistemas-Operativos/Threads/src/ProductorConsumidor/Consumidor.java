package ProductorConsumidor;

public class Consumidor extends Thread{
	private IBuffer<Integer> buffer;
	private long tiempoDeEspera;
	
	public Consumidor(IBuffer bff,long te) {
		this.tiempoDeEspera = te;
		this.buffer = bff;
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		while(true) {
			Integer i = this.buffer.get();
			System.out.println("El thread " + name + " consumio: " + i);
			try {
				Thread.sleep(tiempoDeEspera);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
