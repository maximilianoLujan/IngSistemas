package ProductorConsumidor;

public class main {

	public static void main(String[] args) {
		
		IBuffer<Integer> i = new SynchronizedBuffer<>(10);
		IBuffer<Integer> i2 = new SynchronizedBuffer<>(10);
		//Si le damos mas tiempo de espera al consumidor
		//el buffer se va a llenar mas rapido
		//por lo que al final del programa el productor
		//ya inserto los 100 elementos y el consumidor
		//todavia no llego a leerlos
		//El consumidor nunca espera
		Productor p = new Productor(100,i,10);
		Consumidor c = new Consumidor(i,100);
		
		p.setName("Productor");
		c.setName("Consumidor");
		
		
		p.start();
		c.start();
		
		
		
		//Si le damos mas tiempo de espera al productor
		//el buffer se va a llenar mas lento
		//por lo que a medida que el productor
		//vaya agregando elementos, el consumidor
		//va a ir consumiento esos elementos
		Productor p2 = new Productor(100,i2,100);
		Consumidor c2 = new Consumidor(i2,10);
		
		p2.setName("Productor 2 ");
		c2.setName("Consumidor 2");
		
		p2.start();
		c2.start();
	
	}

}
