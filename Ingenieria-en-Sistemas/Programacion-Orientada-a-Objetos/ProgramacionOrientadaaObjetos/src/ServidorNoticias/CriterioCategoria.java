package ServidorNoticias;

public class CriterioCategoria extends Criterio{
	String categoria;
	
	public CriterioCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public boolean cumple(Noticia n) {
		return n.getCategoria().equals(categoria);
	}
}
