package ServidorNoticias;

import java.util.ArrayList;

public class Servidor {
	ArrayList<Noticia> noticias;
	
	public Servidor() {
		noticias = new ArrayList<Noticia>();
	}
	
	public ArrayList<Noticia> Buscar(Criterio c1) {
		ArrayList<Noticia> noticiasCumplenCriterios = new ArrayList<Noticia>();
		for(int i = 0;i < noticias.size();i++) {
			if(c1.cumple(noticias.get(i))) {
				noticiasCumplenCriterios.add(noticias.get(i));
			}
		}
		return noticiasCumplenCriterios;
	}
	
	public void addNoticia(Noticia n1) {
		noticias.add(n1);
	}
}
