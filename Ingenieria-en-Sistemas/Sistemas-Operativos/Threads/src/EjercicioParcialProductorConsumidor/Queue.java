package EjercicioParcialProductorConsumidor;

import java.util.ArrayList;

public class Queue {
	ArrayList<Item> items = new ArrayList<Item>();
	public final int MAX_ITEMS = 5;
	
	public Queue() {
		
	}
	
	public synchronized int cantItems() {
		return items.size();
	}
	
	public synchronized void addItem(Item i) {
		items.add(i);
		System.out.println( items.size() + "/" + this.MAX_ITEMS);
	}
	
	public synchronized Item getNextItem() {
		return items.remove(0);
	}
	

}
