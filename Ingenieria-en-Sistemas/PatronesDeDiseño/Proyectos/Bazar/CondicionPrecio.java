public class CondicionPrecio implements Condicion{
	double precio;
	
	public CondicionPrecio(double pr) {
		this.precio = pr;
	}
	
	@Override
	public boolean cumple(ElementoBazar el) {
		return el.getPrecio() > this.precio;
	}

}
