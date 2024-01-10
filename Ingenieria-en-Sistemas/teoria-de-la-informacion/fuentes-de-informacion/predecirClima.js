/*
2) Se desea transmitir diariamente el estado del tiempo en cierta región, en la que se pueden presentar días soleados, nublados o lluviosos. Estadísticamente, se conoce que nunca se han presentado dos días soleados seguidos. Si un día está soleado, el siguiente puede estar nublado o lluvioso con igual probabilidad. Si el día se presenta con lluvia o nublado, entonces hay una probabilidad de ½ de que el siguiente día tenga las mismas características; y si cambia, entonces es igualmente probable que sea de cualquiera de las otras posibilidades.

    b) Determine la proporción de días que serán soleados, nublados y lluviosos en estado estacionario
*/
const umbral = 0.0001;


function calcularVectorEstacionario(cantidadIteraciones){
    let emisiones = [0,0,0]
        vectorEstacionario = [0,0,0],
        vectorEstacionarioAnterior = [-1,0,0],
        simbolo = primerSimbolo(),
        n = 0;
        emisiones[simbolo]++;
    while ((n < cantidadIteraciones) && (!converge(vectorEstacionarioAnterior,vectorEstacionario))){
        let s = siguienteDadoAnterior(simbolo);
        emisiones[s]++;
        n++;
        vectorEstacionarioAnterior = [...vectorEstacionario];
        for(let i = 0; i < vectorEstacionario.length;i++){
            vectorEstacionario[i] = emisiones[i] / n;
        }
        simbolo = s;
    }
    
    return vectorEstacionario;
}



function primerSimbolo(){
    const random = Math.random(),
        distribucion = [1/3,2/3,1];
    for(let i = 0;i < distribucion.length;i++){
        if(random <= distribucion[i]){
            return i;
        }
    }
}

function siguienteDadoAnterior(simboloActual){
    const random = Math.random();
    let distribucion = [];
    if(simboloActual == 0){
        distribucion = [0,1/2,1];
    } else if (simboloActual == 1){
        distribucion = [1/4,3/4,1];
    } else {
        distribucion = [1/4,1/2,1];
    }
    for(let i = 0; i < distribucion.length;i++){
        if(random <= distribucion[i]){
            return i;
        }
    }
}

function converge(vectorAnterior,vectorActual){
    for(let i = 0;i < vectorAnterior.length;i++){
        if(Math.abs(vectorAnterior[i] - vectorActual[i]) > umbral){
            return false;
        }
    }
    return true;
}

console.log(calcularVectorEstacionario(100000000));
