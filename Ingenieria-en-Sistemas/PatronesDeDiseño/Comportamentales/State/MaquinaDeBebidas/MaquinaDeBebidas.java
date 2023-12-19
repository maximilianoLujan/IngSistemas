public class MaquinaDeBebidas {
	private Estado estado;
	
	public MaquinaDeBebidas(Estado estado) {
		this.estado = estado;
	}
	
	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void seleccionarBebida() {
		this.estado.seleccionarBebida();
	}
	
	public void cancelarSeleccionBebida() {
		this.estado.cancelarSeleccionBebida();
	}
	
	public void realizarPago(double dinero) {
		this.estado.insertarDinero(dinero);
	}
	
	public void cancelarOperacion() {
		this.estado.cancelarOperacion();
	}
	
	public void dispensarBebida() {
		this.estado.dispensarBebida();
	}
	
	public void reponerStock() {
		this.estado.reponerStock();
	}
}