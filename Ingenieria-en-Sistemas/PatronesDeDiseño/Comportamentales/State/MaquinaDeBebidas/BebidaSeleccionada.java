public class BebidaSeleccionada implements Estado{
	public MaquinaDeBebidas maquina;
	
	public void setMaquinaDeBebidas(MaquinaDeBebidas maquina) {
		this.maquina = maquina;
	}
	
	@Override
	public void seleccionarBebida() {
		System.out.println("La bebida ya ha sido seleccionada");
	}

	@Override
	public void cancelarSeleccionBebida() {
		System.out.println("Cancelando bebida de coca-cola");
		Estado nuevoEstado = new EstadoInicial();
		nuevoEstado.setMaquinaDeBebidas(this.maquina);
		this.maquina.cambiarEstado(nuevoEstado);
	}

	@Override
	public void insertarDinero(double dinero) {
		System.out.println("Se realizo el pago de $" + dinero + " para la coca-cola");
		Estado bebidaPagada = new BebidaPagada(dinero);
		bebidaPagada.setMaquinaDeBebidas(this.maquina);
		this.maquina.cambiarEstado(bebidaPagada);
		
	}

	@Override
	public void cancelarOperacion() {
		System.out.println("No hay operacion para cancelar");
		
	}

	@Override
	public void dispensarBebida() {
		System.out.println("Para dispensar la bebida primero tiene que realizar el pago");
		
	}

	@Override
	public void reponerStock() {
		System.out.println("Hay stock, por favor realice el pago");
		
	}

}
