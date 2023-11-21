package ServidorNoticias;

public class CriterioTitulo extends Criterio{
	String nombre;
	
	public CriterioTitulo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public boolean cumple(Noticia n1) {
		return n1.getTitulo().equals(nombre);
	}

}
