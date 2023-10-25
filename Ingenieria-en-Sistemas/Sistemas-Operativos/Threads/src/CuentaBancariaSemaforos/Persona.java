package CuentaBancariaSemaforos;

public class Persona implements Runnable {
	String nombre;
	Banco b1;
	
	public Persona(String n,Banco b1) {
		this.b1 = b1;
		this.nombre = n;
	}
	
	@Override
	public void run() {
		System.out.println("La persona " + nombre + " con el hilo: " + Thread.currentThread().getId() + " esta depositando $1500");
		b1.depositar(1500);
	}
}
