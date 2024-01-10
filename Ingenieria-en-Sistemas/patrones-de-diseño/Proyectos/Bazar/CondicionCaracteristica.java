public class CondicionCaracteristica implements Condicion{
	String caracteristica;
	
	public CondicionCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	@Override
	public boolean cumple(ElementoBazar el) {
		return el.getCaracteristicas().contains(caracteristica);
	}
}
