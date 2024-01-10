public class CondicionOr implements Condicion{
	Condicion c1;
	Condicion c2;
	
	public CondicionOr(Condicion c1, Condicion c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public boolean cumple(ElementoBazar el) {
		return c1.cumple(el) || c2.cumple(el);
	}

}
