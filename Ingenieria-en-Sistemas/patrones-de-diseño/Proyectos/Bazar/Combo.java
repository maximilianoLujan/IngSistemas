import java.util.*;

public class Combo extends ElementoBazar{
	
	List<ElementoBazar> elementos;
	
	public Combo(String nombre) {
		super(nombre);
		elementos = new ArrayList<ElementoBazar>();
	}
	
	public void addElemento(ElementoBazar elem) {
		this.elementos.add(elem);
	}
	
	public boolean estaVacia() {
		return elementos.size() == 0;
	}

	@Override
	public String getOrigen() {
		if (elementos.size() > 0) {
			return elementos.get(0).getOrigen();
		}
		return null;
	}

	@Override
	public double getPrecio() {
		double suma = 0;
		for(int i = 0; i < elementos.size();i++) {
			suma += elementos.get(i).getPrecio();
		}
		return suma;
	}

	@Override
	public double getPeso() {
		double suma = 0;
		for(int i = 0; i < elementos.size();i++) {
			suma += elementos.get(i).getPeso();
		}
		return suma;
	}

	@Override
	public double getDureza() {
		double dureza = Double.MAX_VALUE;
		for(int i = 0;i < elementos.size();i++) {
			double actualDureza = elementos.get(i).getDureza();
			if(actualDureza < dureza) {
				dureza = actualDureza;
			}
		}
		return dureza;
	}

	@Override
	public List<String> getCaracteristicas() {
		List<String> caracs = new ArrayList<String>();
		for(int i = 0; i < elementos.size();i++) {
			List<String> car = elementos.get(i).getCaracteristicas();
			for(int j = 0; j < car.size();j++) {
				String elem = car.get(j);
				if(!caracs.contains(elem)) {
					caracs.add((elem));
				}
			}
		}
			
		return caracs;
	}
	
	@Override
	public int getCantidadUtensilios() {
		int suma = 0;
		for(int i = 0; i < elementos.size(); i++) {
			suma += elementos.get(i).getCantidadUtensilios();
		}
		return suma;
	}

	@Override
	public List<ElementoBazar> buscar(Condicion c1) {
		List<ElementoBazar> aux = new ArrayList<ElementoBazar>();
		if (c1.cumple(this)) {
			aux.add(this);
		}
		for(int i = 0; i < elementos.size();i++) {
			aux.addAll(elementos.get(i).buscar(c1));
		}
		
		return aux;
	}

	@Override
	public ElementoBazar copia(Condicion c1) {
		if(c1.cumple(this)) {
			Combo c = new Combo(this.getNombre());
			for(int i = 0; i < elementos.size();i++) {
				c.addElemento(elementos.get(i).copia(c1));
			}
			if(!c.estaVacia()) {
				return c;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Combo [elementos=" + elementos + "]";
	}
	
	

}
