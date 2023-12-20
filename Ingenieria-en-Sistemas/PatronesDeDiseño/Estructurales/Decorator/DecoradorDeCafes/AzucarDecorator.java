public class AzucarDecorator extends CafeDecorator{

	public AzucarDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public void getComponentes() {
		System.out.println("azucar");
		bebida.getComponentes();
	}

}