public interface Estado {
	
	public void setMaquinaDeBebidas(MaquinaDeBebidas maquina);
	public void seleccionarBebida();
	public void cancelarSeleccionBebida();
	public void insertarDinero();
	public void cancelarOperacion();
	public void dispensarBebida();
	public void reponerStock();
}