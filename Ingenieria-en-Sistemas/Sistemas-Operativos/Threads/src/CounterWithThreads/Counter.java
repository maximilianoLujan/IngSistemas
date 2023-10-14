package CounterWithThreads;

public class Counter {
	private boolean sincronizado;
	
	
	
	public Counter(boolean sincronizado) {
		this.sincronizado = sincronizado;
	}
	
	public boolean getSincronizado() {
		return this.sincronizado;
	}
	
	public synchronized void mostrarContadorSincronizado(long idHilo,int n) {
		System.out.println("Inicializando hilo con synchronized con id: "+ idHilo + " ");
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}
		System.out.println("Finalizando hilo con synchronized con id: "+ idHilo + " ");
	}
	
	
	public void mostrarContadorNoSincronizado(long idHilo,int n) {
		System.out.println("Inicializando hilo no sincronizado con id: "+ idHilo + " ");
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}
		System.out.println("Finalizando hilo no sincronizado con id: "+ idHilo + " ");
	}
}
