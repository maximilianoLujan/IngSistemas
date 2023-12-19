public class BebidaPagada implements Estado{
	MaquinaDeBebidas maquina;
	double dinero;
	
	public BebidaPagada(double dinero) {
		this.dinero = dinero;
	}
	
	@Override
	public void setMaquinaDeBebidas(MaquinaDeBebidas maquina) {
		this.maquina = maquina;
		
	}

	@Override
	public void seleccionarBebida() {
		System.out.println("La bebida ya fue seleccionada y pagada, por favor presione el dispensor");
	}

	@Override
	public void cancelarSeleccionBebida() {
		System.out.println("Primero debe cancelar el pago");
	}

	@Override
	public void insertarDinero(double dinero) {
		System.out.println("La bebida ya fue pagada, por favor presione el dispensor");
	}

	@Override
	public void cancelarOperacion() {
		System.out.println("Se cancelo el pago de $" + this.dinero);	
		Estado bebidaSeleccionada = new BebidaSeleccionada();
		bebidaSeleccionada.setMaquinaDeBebidas(this.maquina);
		this.maquina.cambiarEstado(bebidaSeleccionada);
	}

	@Override
	public void dispensarBebida() {
		System.out.println("Dispensando la bebida..., que la disfrute!!!");
		Estado sinStock = new SinStock();
		sinStock.setMaquinaDeBebidas(this.maquina);
		this.maquina.cambiarEstado(sinStock);
	}

	@Override
	public void reponerStock() {
		System.out.println("La bebida ya fue pagada y disponemos de stock, por favor presione el dispensor");
		
	}

}