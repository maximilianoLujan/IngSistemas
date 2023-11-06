package EjercicioParcialProductorConsumidor;

public class Productor implements Runnable{
	Queue cola;
	int id;
	
	public Productor(Queue cola, int id) {
		this.cola = cola;
		this.id = id;
	}
	
	@Override
	public void run() {
		if(cola.cantItems() < cola.MAX_ITEMS) {
			cola.addItem(new Item(id));
			System.out.println("Productor " + id + " introdujo un nuevo item");
		}
	}

}
