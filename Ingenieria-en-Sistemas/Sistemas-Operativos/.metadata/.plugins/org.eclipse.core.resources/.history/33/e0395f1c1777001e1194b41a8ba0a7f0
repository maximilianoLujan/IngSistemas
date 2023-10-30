package ProductoresConsumidores;

public class main {

	public static void main(String[] args) {
		Cola c1 = new Cola(100);
		
		Consumidor consumidor = new Consumidor(100,c1);
		consumidor.setName("Consumidor");
		consumidor.start();
		
		
		for (int i = 0; i < 100; i++) {
			Productor p1 = new Productor(c1,100,consumidor);
			p1.setName("Productor " + String.valueOf(i));
			p1.start();
		}

	}

}
