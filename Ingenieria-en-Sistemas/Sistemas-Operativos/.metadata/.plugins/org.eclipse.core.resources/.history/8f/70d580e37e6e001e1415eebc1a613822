package BlancanievesSieteEnanitos;

public class Casa {
	private int cantSillas;
	private int sillasOcupadas;
	
	public Casa(int cantSillas){
		this.sillasOcupadas = 0;
		this.cantSillas = cantSillas;
	}
	
	public synchronized int ocuparSilla() {
		if ((cantSillas - sillasOcupadas) == 0) {
			System.out.println("Estan todas las sillas ocupadas");
			return -1;
		} else {
			sillasOcupadas++;
			return cantSillas - sillasOcupadas;
		}
	}
	
	//Este metodo devuelve si hay sillas libres en la casa
	public synchronized boolean haySillasLibres() {
		return ((cantSillas - sillasOcupadas) > 0);
	}
}
