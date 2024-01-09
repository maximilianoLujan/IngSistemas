/*
Un alumno que debe rendir examen tiene a disposición 5 temas ensobres cerrados (3 de los temas son fáciles y 2 más complejos). Si elige uno de los sobres, lo devuelve y luego saca otro, ambos en forma aleatoria, calcule la probabilidad de que:
al menos uno de los temas sea fácil
sólo uno de los temas sea fácil
el segundo tema sea fácil, si se sabe que el primero es fácil
*/

const umbralError = 0.01;

function sacarTema(){
    const distribucionProbabilidad = [3/5,1],
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

function simularAlMenosUnTemaSeaFacil(n){
    let exitos = 0,
        intentos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = sacarTema(),
            y = sacarTema();
        if ((x === 0) || (y === 0)){
            exitos++;
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que al menos un tema sea facil es de: ${probActual}` )
}

function simularSoloUnTemaSeaFacil(n){
        let exitos = 0,
        intentos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = sacarTema(),
            y = sacarTema();
        if (((x === 0) && (y === 1))|| ((y === 0) &&(x == 1))){
            exitos++;
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que solo un tema sea facil es de: ${probActual}` )
}

function simularSegundoFacilDadoPrimeroFacil(n){
        let exitos = 0,
        intentos = 0,
        probAnt = -1,
        probActual = 0;
    while((intentos < n) || (!converge(probAnt,probActual))){
        const x = 0,
            y = sacarTema();
        if(y === 0){
            exitos++;
        }
        probAnt = probActual;
        probActual = exitos / intentos;
        intentos++;
    }
    console.log(`La probabilidad de que sea un tema sea facil dado que el primero fue facil es de: ${probActual}` )
}

simularAlMenosUnTemaSeaFacil(100000);
simularSoloUnTemaSeaFacil(100000);
simularSegundoFacilDadoPrimeroFacil(10000000);
