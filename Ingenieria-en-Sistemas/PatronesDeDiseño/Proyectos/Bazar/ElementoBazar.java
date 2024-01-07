import java.util.List;

public abstract class ElementoBazar {
	String nombre;
	
	public abstract String getOrigen();
	public abstract double getPrecio();
	public abstract double getPeso();
	public abstract double getDureza();
	public abstract List<String> getCaracteristicas();
	public abstract int getCantidadUtensilios();
	public abstract List<ElementoBazar> buscar(Condicion c1);
	public abstract ElementoBazar copia(Condicion c1);
	
	public ElementoBazar(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}