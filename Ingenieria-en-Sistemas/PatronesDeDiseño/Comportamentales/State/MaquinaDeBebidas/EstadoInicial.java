public class EstadoInicial implements Estado{
	private MaquinaDeBebidas maquina;

	public void setMaquinaDeBebidas(MaquinaDeBebidas maquina) {
		this.maquina = maquina;
	}
	
	@Override
	public void seleccionarBebida() {
		System.out.println("Se ha seleccionado la bebida coca-cola");
		Estado nuevoEstado = new BebidaSeleccionada();
		nuevoEstado.setMaquinaDeBebidas(this.maquina);
		this.maquina.cambiarEstado(nuevoEstado);
	}

	@Override
	public void cancelarSeleccionBebida() {
		System.out.println("No hay ninguna bebida seleccionada");	
	}

	@Override
	public void insertarDinero(double dinero) {
		System.out.println("Por favor, seleccione la bebida que quiere comprar");
	}

	@Override
	public void cancelarOperacion() {
		System.out.println("Por favor, seleccione la bebida que quiere comprar");	
	}

	@Override
	public void dispensarBebida() {
		System.out.println("Por favor, seleccione la bebida que quiere comprar");
		
	}

	@Override
	public void reponerStock() {
		System.out.println("Hay stock, por favor seleccione la bebida que quiere comprar");
	}

}
