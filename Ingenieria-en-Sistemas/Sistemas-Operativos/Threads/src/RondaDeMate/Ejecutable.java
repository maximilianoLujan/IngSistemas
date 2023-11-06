package RondaDeMate;

public class Ejecutable {

	public static void main(String[] args) {
		RondaDeMates rdm = new RondaDeMates(20);
		Cebador c1 = new Cebador(rdm);
		c1.setName("Maxi");
		Tomador t1 = new Tomador(false,c1);
		t1.setName("Carlos");
		Tomador t2 = new Tomador(false,c1);
		t2.setName("Ramon");
		Tomador t3 = new Tomador(false,c1);
		t3.setName("Juan");
		Tomador t4 = new Tomador(false,c1);
		t4.setName("Pedro");
		
		rdm.addTomador(t1);
		rdm.addTomador(t2);
		rdm.addTomador(t3);
		rdm.addTomador(t4);
		
		c1.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
