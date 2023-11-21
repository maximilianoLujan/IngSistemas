package ServidorNoticias;

public class Noticia {
	String titulo;
	String clasificacion;
	Cuerpo c1;
	
	public Noticia(String titulo,String clasificacion,Cuerpo c1) {
		this.titulo = titulo;
		this.clasificacion = clasificacion;
		this.c1 = c1;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCategoria() {
		return clasificacion;
	}
}
