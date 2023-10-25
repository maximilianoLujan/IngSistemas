package ProductorConsumidor;

public class Productor extends Thread{
	private int cantidadElementosAGenerar;
	private IBuffer<Integer> buffer;
	private long tiempoDeEspera;
	
	public Productor(int ce,IBuffer bff,long te) {
		this.tiempoDeEspera = te;
		this.buffer = bff;
		this.cantidadElementosAGenerar = ce;
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i = 1; i <= cantidadElementosAGenerar;i++ ) {
			System.out.println("El thread " + name + " puso el elemento: " + i );
			this.buffer.put(i);
			try {
				Thread.sleep(tiempoDeEspera);
			} catch (InterruptedException e) {
				return;
			}
			
		}
	}
}
