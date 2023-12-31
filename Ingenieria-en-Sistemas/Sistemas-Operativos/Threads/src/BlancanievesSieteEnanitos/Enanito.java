package BlancanievesSieteEnanitos;

public class Enanito extends Thread {
    Casa c1;

    public Enanito(Casa c1) {
        this.c1 = c1;
    }

    @Override
    public void run() {
        try {
            System.out.println("El enanito " + Thread.currentThread().getId() + " está trabajando");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        c1.sentarseAComer(this);
    }

    public synchronized void comer() {
        try {
            System.out.println("El enanito " + Thread.currentThread().getId() + " está comiendo");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        c1.liberarAsiento();
    }
}
