package CounterWithThreads;

public class ThreadCounter implements Runnable{
	
	private Counter c1;
	private int n;
	
	
	public ThreadCounter(Counter c1, int n) {
		this.c1 = c1;
		this.n = n;
	}
	
	@Override
	public void run() {
		if(c1.getSincronizado()) {
			c1.mostrarContadorSincronizado(Thread.currentThread().getId(), this.n);
		} else {
			c1.mostrarContadorNoSincronizado(Thread.currentThread().getId(), n);
		}
	}
	

}
