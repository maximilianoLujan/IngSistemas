package CuentaBancaria;

public class Cuenta {
	double balance;
	
	public Cuenta(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Solo un proceso a la vez puede setear el balance
	public synchronized void setBalance(double b1) {
		this.balance = b1;
	}
	
	//Solo un proceso a la vez puede depositar
	public synchronized void depositar(double deposito) {
		setBalance(balance + deposito);
	}
}
