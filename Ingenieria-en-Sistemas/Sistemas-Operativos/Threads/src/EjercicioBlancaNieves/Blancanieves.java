package EjercicioBlancaNieves;
import java.util.Queue;
import java.util.LinkedList;


public class Blancanieves extends Thread{
	Queue<Enanito> enanitosEsperando;
	
	public Blancanieves() {
		enanitosEsperando = new LinkedList<Enanito>();
	}
	
	@Override
	public void run() { }

}