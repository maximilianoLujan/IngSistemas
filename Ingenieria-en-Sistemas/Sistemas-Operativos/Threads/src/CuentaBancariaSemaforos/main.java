package CuentaBancariaSemaforos;

public class main {

	public static void main(String[] args) {
		Banco cuentaFamiliar = new Banco(0);
		
		Thread p1 = new Thread(new Persona("Mario",cuentaFamiliar));
		Thread p2 = new Thread(new Persona("Facundo",cuentaFamiliar));
		Thread p3 = new Thread(new Persona("Fernando",cuentaFamiliar));
		Thread p4 = new Thread(new Persona("Miriam",cuentaFamiliar));
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
			p4.join();
			
			System.out.println("El balance de la cuenta es: " + cuentaFamiliar.getBalance());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
