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
}