public class CondicionAnd implements Condicion{
	Condicion c1;
	Condicion c2;
	
	public CondicionAnd(Condicion c1,Condicion c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public boolean cumple(ElementoBazar el) {
		return this.c1.cumple(el) && this.c2.cumple(el);
	}
	

}
