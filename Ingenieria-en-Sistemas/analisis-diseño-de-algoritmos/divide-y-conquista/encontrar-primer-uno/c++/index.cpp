/*
Dado un arreglo de las siguientes características: [0, 0, 0, ..., 1, 1, ...] (es decir, ceros seguidos de
unos). Se pide implementar en C++ una función que utilice la técnica de Divide y Conquista para
encontrar el índice del primer 1. Si no hay ningún 1 (solo hay ceros), debe devolver -1. La
complejidad temporal de la solución propuesta debe pertenecer a O(log n).

*/// Online C++ compiler to run C++ program online
#include <iostream>

int encontrarPrimerUno(int arreglo[5],int inicio,int fin){
    int mitad = (inicio + fin) / 2;
    if(inicio == fin){
        if(arreglo[inicio] == 1){
            return inicio;
        } else {
            return -1;
        }
    } else {
        if(arreglo[mitad] == 0){
            return encontrarPrimerUno(arreglo,mitad + 1,fin);
        } else {
            return encontrarPrimerUno(arreglo,inicio,mitad);
        }
    }
}
int main() {
    int ejemploUno[5] = {0,0,0,0,1};
    
    int longBytes = sizeof(ejemploUno);
    int longArreglo = longBytes/sizeof(ejemploUno[0]);
    
    
    int respuesta = encontrarPrimerUno(ejemploUno,0,longArreglo);
    std::cout << respuesta;

    return 0;
}
