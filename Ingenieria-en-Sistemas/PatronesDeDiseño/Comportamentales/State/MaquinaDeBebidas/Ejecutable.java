import java.util.Timer;
import java.util.TimerTask;

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
		maquinaCocaCola.realizarPago(1200);
		maquinaCocaCola.realizarPago(1200);
		maquinaCocaCola.dispensarBebida();
		maquinaCocaCola.dispensarBebida();
		maquinaCocaCola.reponerStock();
		Timer t1 = new Timer();
		t1.schedule(new TimerTask() {
			public void run() {
				maquinaCocaCola.reponerStock();
			}
		}, 5000);
	}
	
}
