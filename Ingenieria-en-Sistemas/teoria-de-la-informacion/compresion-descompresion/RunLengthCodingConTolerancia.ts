/*
El Run-Length Coding (RLC) es una técnica de compresión que representa secuencias repetitivas 
de datos mediante la indicación del valor y la cantidad de repeticiones. 
En este caso, se introduce una tolerancia que permite agrupar valores cercanos, 
considerándolos como parte de la misma secuencia repetitiva si están dentro de la 
tolerancia especificada. Esto significa que valores que difieren en menos o igual 
cantidad a la tolerancia se comprimen juntos, reduciendo la longitud del mensaje original. 
Al aumentar la tolerancia, se pierde más información, pero la compresión puede ser 
más efectiva en ciertos contextos como la compresion de una imagen con colores muy repetitivos.
*/
interface Respuesta {
    simbolo: number,
    repeticiones: number
}

function comprimirRunLengthCoding(tolerancia: number,mensajeOriginal: Array<number>): Array<Respuesta>{
    let currentSimbol: number = mensajeOriginal[0],
        repeticiones: number = 1;
    const mensajeCodificado: Array<Respuesta> = [];
    for(let i = 1; i < mensajeOriginal.length;i++){
        if(mensajeOriginal[i] <= currentSimbol + tolerancia && mensajeOriginal[i] >= currentSimbol - tolerancia){
            repeticiones++;
        } else {
            mensajeCodificado.push({simbolo: currentSimbol,repeticiones});
            currentSimbol = mensajeOriginal[i];
            repeticiones = 1;
        }
    }
    mensajeCodificado.push({simbolo: currentSimbol,repeticiones});
    return mensajeCodificado;
}

function descomprimirRunLengthCoding(mensajeComprimido: Array<Respuesta>): Array<number>{
    const mensajeDecodificado: Array<number> = [];
    for(let i = 0; i < mensajeComprimido.length; i++){
        for(let j = 0; j < mensajeComprimido[i].repeticiones; j++){
            mensajeDecodificado.push(mensajeComprimido[i].simbolo);
        }
    }
    return mensajeDecodificado;
}





const mensajeOriginalRLC: Array<number> = [
    5,5,4,5,5,3,3,3,
    5,5,4,4,10,9,5,5,
    4,5,9,10,9,10,10,10,
    2,2,3,14,13,14,13,13,
    2,2,5,13,14,14,4,5
],
    //A medida que aumentamos la tolerancia, perdemos mas informacion
    tolerancia: number = 2;

console.log('Mensaje a transmitir: ',mensajeOriginalRLC.join(" "))
const mensajeComprimido: Array<Respuesta> = comprimirRunLengthCoding(tolerancia,mensajeOriginalRLC);

console.log('Mensaje codificado',mensajeComprimido.map((el) => `${el.simbolo} ${el.repeticiones} ` ).join(""))

const mensajeDecodificadoRLC: Array<number> = descomprimirRunLengthCoding(mensajeComprimido);

console.log(mensajeDecodificadoRLC.join(" "))