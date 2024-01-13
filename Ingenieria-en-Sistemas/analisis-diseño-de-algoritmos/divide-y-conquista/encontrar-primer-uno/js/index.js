/*
Dado un arreglo de las siguientes características: [0, 0, 0, ..., 1, 1, ...] (es decir, ceros seguidos de
unos). Se pide implementar en C++ una función que utilice la técnica de Divide y Conquista para
encontrar el índice del primer 1. Si no hay ningún 1 (solo hay ceros), debe devolver -1. La
complejidad temporal de la solución propuesta debe pertenecer a O(log n).

*/

let ejemploUno = [0,0,0,0,1,1,1,1],
    ejemploDos = [0,0,0,0,0,0,0,1],
    ejemploTres = [0,0,0,0,0,0];
    
    
function indicePrimerUno(arreglo,inicio,fin){
    const mitad = Math.floor((inicio + fin)/2);
    if(inicio == fin){
        if(arreglo[inicio] === 1){
            return inicio;
        } else {
            return -1;
        }
    } else {
        if(arreglo[mitad] == 0){
            return indicePrimerUno(arreglo,mitad + 1,fin)
        } else {
            return indicePrimerUno(arreglo,inicio,mitad)
        }
    }
}

console.log(indicePrimerUno(ejemploUno,0,ejemploUno.length - 1));
console.log(indicePrimerUno(ejemploDos,0,ejemploDos.length - 1));
console.log(indicePrimerUno(ejemploTres,0,ejemploTres.length - 1));
