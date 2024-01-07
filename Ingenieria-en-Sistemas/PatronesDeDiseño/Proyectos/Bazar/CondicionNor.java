public class CondicionNor implements Condicion{
	Condicion c1;
	
	public CondicionNor(Condicion c1) {
		this.c1 = c1;
	}
	
	
	@Override
	public boolean cumple(ElementoBazar el) {
		return !c1.cumple(el);
	}

}
