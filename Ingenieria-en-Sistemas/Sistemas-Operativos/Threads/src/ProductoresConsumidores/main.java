package ProductoresConsumidores;

public class main {

	public static void main(String[] args) {
		Cola c1 = new Cola(100);
		
		Consumidor consumidor = new Consumidor(c1,100);
		
		consumidor.start();
		
		for (int i = 0; i < 100; i++) {
			Productor productor = new Productor(c1,100);
			productor.start();
		}

	}

}
