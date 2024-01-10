public class CondicionDureza implements Condicion{
	double dureza;
	
	public CondicionDureza(double dureza) {
		this.dureza = dureza;
	}

	@Override
	public boolean cumple(ElementoBazar el) {
		return el.getDureza() < this.dureza;
	}

}
