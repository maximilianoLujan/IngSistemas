/*
Dado un arreglo de las siguientes caracteristicas: [0, 0, 0, ..., 1, 1, ...] (es decir, ceros seguidos de
unos). Se pide implementar en C++ una funcion que utilice la tecnica de Divide y Conquista para
encontrar el indice del primer 1. Si no hay ningun 1 (solo hay ceros), debe devolver -1. La
complejidad temporal de la solucion propuesta debe pertenecer a O(log n).
*/

import java.util.*;

class PrimerUnoDivideYConquista {
    public static void main(String[] args) {
        List<Integer> ejemploUno = new ArrayList<Integer>();
        List<Integer> ejemploDos = new ArrayList<Integer>();
        List<Integer> ejemploTres = new ArrayList<Integer>();
        ejemploUno.add(0);
        ejemploUno.add(0);
        ejemploUno.add(0);
        ejemploUno.add(0);
        ejemploUno.add(1);
        ejemploDos.add(0);
        ejemploDos.add(0);
        ejemploDos.add(0);
        ejemploTres.add(0);
        ejemploTres.add(0);
        ejemploTres.add(0);
        ejemploTres.add(0);
        ejemploTres.add(0);
        ejemploTres.add(1);
        
        
        System.out.println(encontrarPrimerUno(ejemploUno,0,ejemploUno.size() - 1));
        System.out.println(encontrarPrimerUno(ejemploDos,0,ejemploDos.size() - 1));
        System.out.println(encontrarPrimerUno(ejemploTres,0,ejemploTres.size() - 1));
    }
    
    public static int encontrarPrimerUno(List<Integer> arreglo,int inicio,int fin){
        int mitad = (inicio + fin)/2;
        if(inicio == fin){
            if (arreglo.get(inicio) == 1){
                return inicio;
            } else {
                return -1;
            }
        } else {
            if (arreglo.get(mitad) == 0){
                return encontrarPrimerUno(arreglo,mitad + 1,fin);
            } else {
                return encontrarPrimerUno(arreglo,inicio,mitad);
            }
        }
    }
}