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
	public void insertarDinero() {
		System.out.println("Para pagar debes seleccionar una bebida");
		
	}

	@Override
	public void cancelarOperacion() {
		System.out.println("No hay ninguna bebida seleccionada");	
	}

	@Override
	public void dispensarBebida() {
		System.out.println("No hay ninguna bebida seleccionada");
		
	}

	@Override
	public void reponerStock() {
		System.out.println("No hay ninguna bebida seleccionada");
	}

}