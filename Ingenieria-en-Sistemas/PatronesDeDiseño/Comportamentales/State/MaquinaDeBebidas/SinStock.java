import java.util.Timer;
import java.util.TimerTask;

public class SinStock implements Estado{
	MaquinaDeBebidas maquina;
	
	@Override
	public void setMaquinaDeBebidas(MaquinaDeBebidas maquina) {
		this.maquina = maquina;
	}

	@Override
	public void seleccionarBebida() {
		System.out.println("Primero seleccione el boton de reponer stock");
	}

	@Override
	public void cancelarSeleccionBebida() {
		System.out.println("No hay bebida seleccionada");
		
	}

	@Override
	public void insertarDinero(double dinero) {
		System.out.println("Primero reponga stock y seleccione la bebida");
		
	}

	@Override
	public void cancelarOperacion() {
		System.out.println("No hay ninguna operacion");
		
	}

	@Override
	public void dispensarBebida() {
		System.out.println("La bebida ya fue dispensada, por favor presione el boton para reponer el stock");
		
	}

	@Override
	public synchronized void reponerStock() {
		System.out.println("Reponiendo stock, espere durante 5 segundos...");
		Timer timer = new Timer();
		timer.schedule(
			new TimerTask(){
				public void run() {
					Estado inicial = new EstadoInicial();
					inicial.setMaquinaDeBebidas(SinStock.this.maquina);
					SinStock.this.maquina.cambiarEstado(inicial);
					System.out.println("Ya contamos con stock");
				}
			} , 5000);
	}
	
}
