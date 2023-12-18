public class Ejecutable {
	
	public static void main(String[] args) {
		Estado inicial = new EstadoInicial();
		MaquinaDeBebidas maquinaCocaCola = new MaquinaDeBebidas(inicial);
		inicial.setMaquinaDeBebidas(maquinaCocaCola);
		
		maquinaCocaCola.seleccionarBebida();
		maquinaCocaCola.seleccionarBebida();
		maquinaCocaCola.cancelarSeleccionBebida();
		maquinaCocaCola.cancelarSeleccionBebida();
		maquinaCocaCola.seleccionarBebida();
	}
}