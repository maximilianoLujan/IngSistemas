package BlancanievesSieteEnanitos;

public class Blancanieves extends Thread {
    public Blancanieves() {
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void avisar(Enanito e1) {
        this.notify();
        e1.comer();
    }
}
