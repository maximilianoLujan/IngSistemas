package ProductoresConsumidores;

public class Productor extends Thread {
	private int elementosAProducir;
	private Cola c1;
	private Consumidor consumidor;
	
	public Productor(Cola c1,int elementosAProducir,Consumidor c) {
		this.c1 = c1;
		this.elementosAProducir = elementosAProducir;
		this.consumidor = c;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= elementosAProducir; i++) {
			producirElemento(i);
		}
	}
	
	public synchronized void producirElemento(int elem) {
		if (c1.estaLlena()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("El " + Thread.currentThread().getName() + " produjo el elemento " + elem);
		c1.addElemento(elem);
		consumidor.seInsertoElemento();
		consumidor.agregarProductor(this);
	}
	public void seConsumio() {
		this.notify();
	}
}
