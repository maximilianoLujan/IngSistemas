package ManoDeTruco;
import java.util.concurrent.*;

public class Ejecutable {

	public static void main(String[] args) {
        Semaphore turnoJugador1 = new Semaphore(1);
        Semaphore turnoJugador2 = new Semaphore(0);
        Semaphore finJuego = new Semaphore(6);

        Jugador jugador1 = new Jugador("Jugador 1", turnoJugador1, turnoJugador2, finJuego);
        Jugador jugador2 = new Jugador("Jugador 2", turnoJugador2, turnoJugador1, finJuego);

        jugador1.start();
        jugador2.start();

    }

}
