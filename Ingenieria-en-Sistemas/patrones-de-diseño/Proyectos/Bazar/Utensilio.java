import java.util.*;

public class Utensilio extends ElementoBazar{
	String origen;
	double precio;
	double peso;
	double dureza;
	List<String> caracteristicas;
	
	
	public Utensilio(String nombre, String origen, double precio, double peso, double dureza) {
		super(nombre);
		this.origen = origen;
		this.precio = precio;
		this.peso = peso;
		this.dureza = dureza;
		this.caracteristicas = new ArrayList<String>();;
	}
	
	public void addCaracteristica(String ca) {
		if(!caracteristicas.contains(ca)) {
			caracteristicas.add(ca);
		}
	}


	@Override
	public String getOrigen() {
		return this.origen;
	}


	@Override
	public double getPrecio() {
		return this.precio;
	}


	@Override
	public double getPeso() {
		return this.peso;
	}


	@Override
	public double getDureza() {
		return this.dureza;
	}


	@Override
	public List<String> getCaracteristicas() {
		return new ArrayList<String>(this.caracteristicas);
	}
	
	@Override
	public int getCantidadUtensilios() {
		return 1;
	}

	@Override
	public List<ElementoBazar> buscar(Condicion c1) {
		List<ElementoBazar> aux = new ArrayList<ElementoBazar>();
		if(c1.cumple(this)) {
			aux.add(this);
		}
		return aux;
	}

	@Override
	public ElementoBazar copia(Condicion c1) {
		if (c1.cumple(this)) {
			Utensilio u1 = new Utensilio(this.getNombre(),this.getOrigen(),this.getPrecio(),this.getPeso(),this.getDureza());
			List<String> car = this.getCaracteristicas();
			for(int i = 0; i < car.size();i++) {
				u1.addCaracteristica(car.get(i));
			}
			return u1;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Utensilio [origen=" + origen + ", precio=" + precio + ", peso=" + peso + ", dureza=" + dureza
				+ ", caracteristicas=" + caracteristicas + "]";
	}
	
	
	
	
}