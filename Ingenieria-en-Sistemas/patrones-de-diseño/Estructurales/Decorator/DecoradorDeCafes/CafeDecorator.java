public abstract class CafeDecorator extends Bebida{
	Bebida bebida;
	
	public CafeDecorator(Bebida bebida) {
		this.bebida = bebida;
	}
	
}