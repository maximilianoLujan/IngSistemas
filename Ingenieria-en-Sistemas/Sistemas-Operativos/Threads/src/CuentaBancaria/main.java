package CuentaBancaria;

public class main {

	public static void main(String[] args) {
		//Creo una cuenta con balance en 0
		Cuenta cuentafamiliar = new Cuenta(0);
		
		Persona p1 = new Persona("Maximiliano",cuentafamiliar);
		Persona p2 = new Persona("Nicolas",cuentafamiliar);
		Persona p3 = new Persona("Mariano",cuentafamiliar);
		Persona p4 = new Persona("Norberto",cuentafamiliar);

		//Las cuatro personas depositan 1000 en la cuenta
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
			p4.join();
			System.out.println("El balance final de la cuenta es " + "$" + cuentafamiliar.getBalance() );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
