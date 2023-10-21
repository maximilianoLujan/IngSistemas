package ProblemaBarberia;

public class Barbero implements Runnable{
	Barberia barberia;
	boolean dormido;
	
	public Barbero(Barberia barberia) {
		this.barberia = barberia;
		dormido = true;
		
	}
	
	
	@Override
	public void run() {
		Cliente proximo;
		while(true) {
			proximo = llamarProximo();
			cortarPelo(proximo);
		}
	}
	
	public void despertar() {
		this.dormido = false;
		
	}
	public void cortarPelo(Cliente c1) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		c1.terminoCorteDePelo();
		System.out.println("Barbero termina de atender a cliente " + c1.name);
	}
	
	public Cliente llamarProximo() {
		Cliente next = barberia.proximoCliente();
		
		while(next == null) {
			dormido = true;
			System.out.println("Barbero duerme porque no hay clientes");
			while(dormido) {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			next = barberia.proximoCliente();
		}
		System.out.println("Barbero empieza a atender cliente" + next.name);
		return next;
	}
}
