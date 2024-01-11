/*
3) Considere una fuente markoviana que emite símbolos {0,1,2} según la siguiente matriz de pasaje:
a) Considerando que el símbolo emitido inicialmente es 0, obtenga la distribución de probabilidades de emisión en los pasos 1, 2 y 3
[[1/4,3/4,0],
[1/2,1/4,1/2],
[1/4,0,1/2]]

*/

const umbral = 0.0001;

function distribucionEnNPasos(n,cantidadPasos,simboloArranque){
    let probabilidadActual = [0,0,0],
        probabilidadAnterior = [-1,0,0],
        emisiones = [0,0,0],
        simboloInicial = simboloArranque,
        index = 1;
        
    emisiones[simboloInicial]++;
    
    while((index <= n) || (!converge(probabilidadAnterior,probabilidadActual))){
        let simbolo = simularPasos(cantidadPasos,simboloInicial);
        index++;
        emisiones[simbolo]++;
        probabilidadAnterior = [...probabilidadActual];
        for(let i = 0;i < probabilidadActual.length;i++){
            probabilidadActual[i] = emisiones[i]/index;
        }
    }
    return probabilidadActual;
}


//La funcion simular pasos recibe una cantidad de pasos y el 
//simbolo actual y devuelve el simbolo nuevo luego de dar
//esa cantidad de pasos
function simularPasos(cantidadPasos,simboloActual){
    let i = 0,
        simbolo = simboloActual;
    while (i < cantidadPasos){
        const sim = siguienteDadoAnterior(simbolo);
        simbolo = sim;
        i++;
    }
    return simbolo;
}

function primerSimbolo(){
    return 0;
}

function siguienteDadoAnterior(s){
    let distribucionProbabilidades = [];
    const random = Math.random();
    if (s == 0){
        distribucionProbabilidades = [1/4,3/4,1];
    } else if (s == 1){
        distribucionProbabilidades = [3/4,1,1];
    } else {
        distribucionProbabilidades = [0,1/2,1];
    }
    for(let i = 0;i < distribucionProbabilidades.length;i++){
        if(random < distribucionProbabilidades[i]){
            return i;
        }
    }
}

function converge(probAnterior,probActual){
    for(let i = 0;i < probAnterior.length;i++){
        if(Math.abs(probAnterior[i] - probActual[i]) > umbral){
            return false;
        }
    }
    return true;
}


console.log('\nDistribucion de probabilidades si el primer simbolo fue un 0:')
console.log('En 1 paso:')
console.log(distribucionEnNPasos(1000000,1,0))
console.log('En 2 pasos')
console.log(distribucionEnNPasos(1000000,2,0))
console.log('En 3 pasos')
console.log(distribucionEnNPasos(1000000,3,0))
console.log('\nDistribucion de probabilidades si el primer simbolo fue un 1:')
console.log('En 1 paso:')
console.log(distribucionEnNPasos(1000000,1,1))
console.log('En 2 pasos')
console.log(distribucionEnNPasos(1000000,2,1))
console.log('En 3 pasos')
console.log(distribucionEnNPasos(1000000,3,1))
console.log('\nDistribucion de probabilidades si el primer simbolo fue un 2:')
console.log('En 1 paso:')
console.log(distribucionEnNPasos(1000000,1,2))
console.log('En 2 pasos')
console.log(distribucionEnNPasos(1000000,2,2))
console.log('En 3 pasos')
console.log(distribucionEnNPasos(1000000,3,2))