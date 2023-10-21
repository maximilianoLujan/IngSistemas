package BlancanievesSieteEnanitos;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Casa casa = new Casa(4);
		
		for(int i = 0; i < 7;i++) {
			Enanito en = new Enanito(false,casa);
			en.start();
			Thread.sleep(2000);
		}

	}

}
