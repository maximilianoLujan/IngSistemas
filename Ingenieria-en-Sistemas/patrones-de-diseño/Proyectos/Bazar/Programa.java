
public class Programa {

	public static void main(String[] args) {
		Combo c = new Combo("todo");
		Combo c1 = new Combo("ComboAsado");
		Combo c2 = new Combo("Cocina");
		Utensilio el2 = new Utensilio("Cuchillo","Colombia",2000,0.3,15.4);
		Utensilio el3 = new Utensilio("Tenedor","Argentina",1800,0.3,11.4);
		Utensilio el4 = new Utensilio("Cuchara","Argentina",1500,0.2,15.4);
		Utensilio el5 = new Utensilio("Parrilla","Argentina",8000,8,15.4);
		Utensilio el6 = new Utensilio("Yerba","Brasil",500,1,1);
		
		el2.addCaracteristica("filoso");
		el2.addCaracteristica("cortante");
		el3.addCaracteristica("filoso");
		el4.addCaracteristica("pequeña");
		el5.addCaracteristica("comoda");
		el5.addCaracteristica("pequeña");
		c1.addElemento(el2);
		c2.addElemento(el3);
		c2.addElemento(el4);
		c2.addElemento(el5);
		c.addElemento(el6);
		c.addElemento(c1);
		c.addElemento(c2);
		
		System.out.println(c.getOrigen());
		System.out.println(c.getPrecio());
		System.out.println(c.getPeso());
		System.out.println(c.getDureza());
		System.out.println(c.getCaracteristicas());
		System.out.println(c.getCantidadUtensilios());
		
		Condicion condicion = new CondicionOrigen("Colombia");
		
		System.out.println(c.buscar(condicion));
		
		Condicion condicion2 = new CondicionCaracteristica("filoso");
		
		Condicion condicion3 = new CondicionAnd(condicion,condicion2);
		Bazar b1 = new Bazar(condicion3);
		
		System.out.println(b1.puedeMostrarseEnVidriera(el3));
		System.out.println(b1.puedeMostrarseEnVidriera(el2));
		

	}

}
