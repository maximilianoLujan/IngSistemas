package CuentaBancaria;

public class Persona extends Thread{
	String nombre;
	Cuenta cuenta;
	
	public Persona(String nombre,Cuenta cuenta) {
		this.nombre = nombre;
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		System.out.println(nombre + " con el hilo: " + Thread.currentThread().getId() + " esta depositando el dinero");
		cuenta.depositar(1000);
	}
	
	
}
