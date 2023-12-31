package BlancanievesSieteEnanitos;

import java.util.concurrent.Semaphore;

public class Casa {
    private Semaphore sillasDisponibles;
    Blancanieves blancanieves;

    public Casa(int cantSillas, Blancanieves b) {
        this.sillasDisponibles = new Semaphore(cantSillas);
        this.blancanieves = b;
    }

    public void sentarseAComer(Enanito e1) {
        try {
            System.out.println("El enanito " + Thread.currentThread().getId() + " está esperando por un asiento" + sillasDisponibles.availablePermits());
            sillasDisponibles.acquire();
            System.out.println("El enanito " + Thread.currentThread().getId() + " se sentó y está esperando por la comida");
            blancanieves.avisar(e1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberarAsiento() {
        sillasDisponibles.release();
        System.out.println("El enanito " + Thread.currentThread().getId() + " liberó un asiento");
    }
}
