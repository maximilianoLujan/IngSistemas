package ProblemaBarberia;

public class Cliente extends Thread{
	String name;
	Barberia barberia;
	boolean peloCortado = false;
	
	public Cliente(String name,Barberia b) {
		this.name = name;
		this.barberia = b;
	}
	
	@Override
	public void run() {
		if(barberia.hayAsientoLibre()) {
			barberia.tomarAsiento(this);
			esperarCorteDePelo();
		} else {
			System.out.println("Cliente " + name + " no encontro lugar y se retiro de la barberia");
		}
	}
	
	public synchronized void esperarCorteDePelo() {
		while (!peloCortado)
			try {
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		System.out.println("Cliente" + name + "se va de la barberia con su pelo cortado");
	}
	
	public synchronized void terminoCorteDePelo() {
		this.peloCortado = true;
		System.out.println("Cliente " + name + "fue atendido" );
		this.notify();
	}
}
