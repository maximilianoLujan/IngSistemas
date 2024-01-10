//Idem a temasConReposicion pero los temas no se reponen una vez que son sacados

const umbralError = 0.01;

function sacarPrimerTema(){
    const distribucionProbabilidad = [3/5,1],
        sacoDelSobre = Math.random();
        
    for(let i = 0;i < distribucionProbabilidad.length;i++){
        if(sacoDelSobre <= distribucionProbabilidad[i]){
            return i;
        }
    }
}
function sacarSegundoTema(temaAnterior){
    const distribucionProbabilidad = temaAnterior == 0?[1/2,1]:[3/4,1],
        sacoDelSobre = Math.random();
    for(let i = 0;i < distribucionProbabilidad.length;i++){
        if(sacoDelSobre <= distribucionProbabilidad[i]){
            return i;
        }
    }
}

function converge(probAnt,probActual){
    if(Math.abs(probAnt - probActual) > umbralError){
        return false;
    }
    return true;
}

function simularAlMenosUnTemaFacil(n){
    let intentos = 0,
        exitos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = sacarPrimerTema(),
            y = sacarSegundoTema(x);
        if((x == 0) || (y == 0)){
            exitos++
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que al menos un tema sea facil es de: ${probAnt}`)
}


function simularSoloUnTemaFacil(n){
    let intentos = 0,
        exitos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = sacarPrimerTema(),
            y = sacarSegundoTema(x);
        if(((x == 0) && (y == 1)) || ((y == 0) && (x == 1))){
            exitos++
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que solo un tema sea facil es de: ${probAnt}`)
}


function simularFacilDadoFacil(n){
    let intentos = 0,
        exitos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = 0,
            y = sacarSegundoTema(x);
        if (y == 0){
            exitos++
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que sea facil dado que el primero fue facil es de: ${probAnt}`)
}


simularAlMenosUnTemaFacil(10000000);
simularSoloUnTemaFacil(10000000);
simularFacilDadoFacil(10000000);
