public class Programa {
	public static void main(String[] args) {
		Bebida cafe = new Cafe();
		Bebida cafeConLeche = new LecheDecorator(cafe);
		Bebida cafeConLecheyAzucar = new AzucarDecorator(cafeConLeche);
		
		cafeConLecheyAzucar.getComponentes();
		
		
		//Y si quiero que mi cafe tengo 2 cucharadas de azucar?...
		
		
		Bebida cafeConLecheyDobleAzucar = new AzucarDecorator(cafeConLecheyAzucar);
		
		System.out.println("----------------------");
		cafeConLecheyDobleAzucar.getComponentes();
		
		
		
	}
}
