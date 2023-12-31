package CuentaBancariaSemaforos;

import java.util.concurrent.Semaphore;

public class Banco {
	double balance;
	Semaphore semaforo;
	
	public Banco(double balance) {
		this.balance = balance;
		semaforo = new Semaphore(2,true);
	}
	public void depositar(double monto) {
		try {
			//Reclama el semaforo, si este esta en 0 se bloquea el proceso
			semaforo.acquire();
			balance = balance + monto;
		} catch (Exception e) {
			throw new Error(e);
		}
		semaforo.release();
	}
	public double getBalance() {
		return balance;
	}
}
