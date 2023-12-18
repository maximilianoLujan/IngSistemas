public public class BebidaSeleccionada implements Estado{
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
	public void insertarDinero() {
		System.out.print("Se realizo el pago para la coca-cola");
		
	}

	@Override
	public void cancelarOperacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispensarBebida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reponerStock() {
		// TODO Auto-generated method stub
		
	}

} 
