package ArrayMedia;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int[] prueba = new int[10000];
		for(int i = 0; i < prueba.length;i++ ) {
			prueba[i] = i;
		}
		
		
		//Creamos los cuatro hilos con sus respectivas partes del arreglo
		ThreadMedia t1 = new ThreadMedia(prueba,0,2500);
		ThreadMedia t2 = new ThreadMedia(prueba,2500,5000);
		ThreadMedia t3 = new ThreadMedia(prueba,5000,7500);
		ThreadMedia t4 = new ThreadMedia(prueba,7500,10000);
		
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			
			double mediaReal = ((t1.getResultado() + t2.getResultado() + t3.getResultado() + t4.getResultado())/ 4);
			
			System.out.println("La media es: " + mediaReal);
			
		} catch(Error r) {
			throw new InterruptedException("Sucedio un error");
		}
		
		
	}

}
