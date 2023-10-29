package ProductoresConsumidores;

import java.util.ArrayList;

public class Consumidor extends Thread{
	private int elementosAConsumir;
	Cola c1;
	private ArrayList<Productor> productores;
	
	public Consumidor(int elementosAConsumir,Cola c1) {
		this.c1 = c1;
		this.elementosAConsumir = elementosAConsumir;
		productores = new ArrayList<Productor>();
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= elementosAConsumir; i++) {
			consumirElemento();
		}
	}
	
	public synchronized void consumirElemento() {
		while(true) {
			while(c1.estaVacia()) {
				try {
					System.out.println("El thread " + Thread.currentThread().getName() + " no encontro elementos en la cola y se durmio");
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int elem = c1.getElemento();
			System.out.println("El thread " + Thread.currentThread().getName() + "consumio el elemento " + elem);
			avisarProductores();			
		}
	}
	
	public synchronized void seInsertoElemento() {
		this.notify();
	}
	
	public synchronized void avisarProductores() {
		for (int i = 0; i < productores.size(); i++) {
			productores.get(i).seConsumio();
		}
	}
	
	public synchronized void agregarProductor(Productor p) {
		this.productores.add(p);
	}
	
}
