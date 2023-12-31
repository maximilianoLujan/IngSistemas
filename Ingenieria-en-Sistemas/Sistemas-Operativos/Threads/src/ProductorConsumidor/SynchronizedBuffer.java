package ProductorConsumidor;
import java.util.List;
import java.util.LinkedList;

public class SynchronizedBuffer<T> implements IBuffer<T> {
	private List<T> data;
	private int maxSize;
	
	
	
	
	
	public SynchronizedBuffer(int maxSize) {
		super();
		this.data = new LinkedList<T>();
		this.maxSize = maxSize;
	}

	@Override
	public synchronized void put(T elemento) {
		while(this.data.size() >= this.maxSize) {
			try {
				System.out.println(Thread.currentThread().getName() + " espera porque la lista esta llena");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data.add(elemento);
		System.out.println("El tamaño de la lista: " + data.size() + "/" + maxSize);
		this.notify();
		
	}

	@Override
	public synchronized T get() {
		while(this.data.isEmpty()) {
			try {
				System.out.println(Thread.currentThread().getName() + "espera porque no hay elementos");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		T elemento = this.data.remove(0);
		System.out.println("El tamaño de la lista: " + data.size() + "/" + maxSize);		
		return elemento;
	}

}
