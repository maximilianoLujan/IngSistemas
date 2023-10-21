package CuentaBancaria;

public class Cuenta {
	double balance;
	
	public Cuenta(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Solo un proceso a la vez puede depositar
	public synchronized void depositar(double deposito) {
		this.balance = this.balance + deposito;
	}
}
