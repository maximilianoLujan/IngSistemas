package EjercicioParcialProductorConsumidor;

public class Ejecutable {

	public static void main(String[] args) {
		Queue c1 = new Queue();
		// TODO Auto-generated method stub
		for (int i = 1; i < 101; i++) {
			Thread t1 = new Thread(new Productor(c1,i));
			t1.start();
		}
	}

}
