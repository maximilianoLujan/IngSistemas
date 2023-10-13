package ArrayMedia;

public class ThreadMedia extends Thread{
	
	private int[] array = new int[10000];
	private int inicio;
	private int fin;
	private double resultado;
	
	public ThreadMedia(int[] arreglo,int i,int f) {
		this.array = arreglo;
		this.inicio = i;
		this.fin = f;
		resultado = 0;
	}
	
	@Override
	public void run() {
		int suma = 0;
		for(int i = inicio; i < fin;i++ ) {
			suma += array[i];
		}
		this.resultado = suma/(fin - inicio);
	}

	public double getResultado() {
		return resultado;
	}
}
