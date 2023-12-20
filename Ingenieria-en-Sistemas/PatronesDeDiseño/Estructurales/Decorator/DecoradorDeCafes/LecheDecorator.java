public class LecheDecorator extends CafeDecorator{

	public LecheDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public void getComponentes() {
		System.out.println("leche");
		bebida.getComponentes();
	}
}
