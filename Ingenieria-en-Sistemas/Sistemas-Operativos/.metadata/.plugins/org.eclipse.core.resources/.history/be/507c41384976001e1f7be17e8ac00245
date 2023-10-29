package EjercicioBlancaNieves;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Blancanieves y los siete enanitos viven en una casa donde sólo existen cuatro sillas que los enani-
			tos utilizan para comer. Cuando un enanito vuelve de trabajar comprueba si hay una silla libre
			para sentarse. Si existe una silla libre, entonces indica a Blancanieves que ya está sentado y espera
			pacientemente que le sirva la comida. Cuando le ha servido, Blancanieves le indica que puede em-
			pezar a comer. El enanito come y cuando acaba, deja la silla libre y vuelve a trabajar. Por su parte
			Blancanieves, cuando no tiene ningún enanito pendiente de servirle, se va a pasear con su amigo el
			Príncipe.
			Escriba un programa que ejecute las funciones descritas. Debe existir un thread para Blancanieves y
			un thread para cada enanito. La solución debe estar libre de deadlocks. La solución debe maximizar
			la concurrencia de los thread. Argumente por qué la solución está libre de deadlocks.
		 * 
		 * 
		 * */
		
		Casa c1 = new Casa(4);
		
		
		Enanito e1 = new Enanito(c1);
		Enanito e2 = new Enanito(c1);
		Enanito e3 = new Enanito(c1);
		Enanito e4 = new Enanito(c1);
		Enanito e5 = new Enanito(c1);
		Enanito e6 = new Enanito(c1);
		Enanito e7 = new Enanito(c1);
		
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
		e6.start();
		e7.start();
		
	}

}
