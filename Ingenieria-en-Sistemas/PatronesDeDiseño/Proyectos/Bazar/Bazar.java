import java.util.*;

public class Bazar {
	List<ElementoBazar> productos;
	Condicion seMuestraEnVidriera;

	public Bazar(Condicion c1) {
		productos = new ArrayList<ElementoBazar>();
		this.seMuestraEnVidriera = c1;
	}
	public void addProducto(ElementoBazar el) {
		productos.add(el);
	}
	
	public List<ElementoBazar> buscar(Condicion c1){
		List<ElementoBazar> aux = new ArrayList<ElementoBazar>();
		for(int i = 0;i < productos.size();i++) {
			aux.addAll(productos.get(i).buscar(c1));
		}
		return aux;
	}
	
	public boolean puedeMostrarseEnVidriera(ElementoBazar el) {
		return seMuestraEnVidriera.cumple(el);
	}
}