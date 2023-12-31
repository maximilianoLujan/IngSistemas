package CounterWithThreads;

public class Main {

	public static void main(String[] args) {
		Counter c1 = new Counter(true);
		
		//Como a un metodo declarado con synchronized solo lo puede estar ejecutando un proceso a la vez,
		//en el caso de abajo se va a ejecutar uno y luego el otro
		Thread hiloUnoSincronizado = new Thread(new ThreadCounter(c1,5));
		Thread hiloDosSincronizado = new Thread(new ThreadCounter(c1,100));
	
		hiloUnoSincronizado.start();
		hiloDosSincronizado.start();
		

		
		
		//En cambio, en el caso de abajo se van a ejecutar dependiendo el tiempo que les de el cpu scheduling
		Counter c2 = new Counter(false);
		
		
		Thread hiloUnoNoSincronizado = new Thread(new ThreadCounter(c2,50));
		Thread hiloDosNoSincronizado = new Thread(new ThreadCounter(c2,100));
	
		hiloUnoNoSincronizado.start();
		hiloDosNoSincronizado.start();
	}

}
