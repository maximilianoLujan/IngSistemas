package BlancanievesSieteEnanitos;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Blancanieves b1 = new Blancanieves();
        Casa casa = new Casa(4, b1);
        b1.start();
        
        for (int i = 0; i < 7; i++) {
            Enanito en = new Enanito(casa);
            en.start();
        }
    }
}
