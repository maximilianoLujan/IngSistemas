package ProblemaBarberia;

public class main {

	public static void main(String[] args) throws InterruptedException {
		Barberia sala = new Barberia(3);
		Barbero barbero = new Barbero(sala);
		sala.setBarbero(barbero);
		
		new Thread(barbero).start();

		for(int i = 0; i < 30; i++) {
			Thread.sleep(1000);
			new Cliente(Integer.toString(i),sala).start();
		}
	}

}
