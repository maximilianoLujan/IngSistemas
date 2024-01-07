public class CondicionOrigen implements Condicion{
	public String origen;
	
	public CondicionOrigen(String origen) {
		this.origen = origen;
	}
	
	@Override
	public boolean cumple(ElementoBazar el) {
		return (el.getOrigen().compareTo(origen) == 0);
	}
	

}
