package SumArrayElementsWithThreads;

public class Main {

	public static void main(String[] args) throws Exception {
		int[] arrayToSum = new int[100000000];
		
		for (int i = 0; i < arrayToSum.length; i++) {
			arrayToSum[i] = (int)(Math.random() * 10);
		}
		
		//Vamos a realizar la suma normal con un for O(n)
		int sum = 0;
		for (int i = 0; i < arrayToSum.length; i++) {
			sum += arrayToSum[i];
		}
		System.out.println("La suma realizada sin hilos: " + sum);
		
		
		//Ahora vamos a realizarlo con hilos, 
		ThreadSum t1 = new ThreadSum(arrayToSum,0,25000000);
		ThreadSum t2 = new ThreadSum(arrayToSum,25000000,50000000);
		ThreadSum t3 = new ThreadSum(arrayToSum,50000000,75000000);
		ThreadSum t4 = new ThreadSum(arrayToSum,75000000,100000000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			int sumHilos = t1.getResult() 
					+ t2.getResult() 
					+ t3.getResult()
					+ t4.getResult();
			System.out.println("La suma realizada con hilos: " + sumHilos);
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		
		
	}

}
