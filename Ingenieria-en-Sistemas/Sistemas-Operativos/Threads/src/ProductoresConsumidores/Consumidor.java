package ProductoresConsumidores;


public class Consumidor extends Thread{
	private Cola c1;
	private int elementosAConsumir;
	
	public Consumidor(Cola c1,int elementosAConsumir) {
		this.c1= c1;
		this.elementosAConsumir = elementosAConsumir;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= this.elementosAConsumir; i++) {
			consumirElemento();
		}
	}
	
	public void consumirElemento() {
		synchronized(c1) {
			while(c1.estaVacia())
				try {
					System.out.println("El consumidor se quedo esperando porque la cola esta vacia");
					c1.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			int elementoConsumido = c1.getElemento();
			System.out.println("El consumidor consumio el elemento: " + elementoConsumido);
			c1.notify();
		}	
	}
}
