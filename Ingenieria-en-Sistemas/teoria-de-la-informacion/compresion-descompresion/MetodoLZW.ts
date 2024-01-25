function compresorLZW(mensajeOriginal: string, simbolos: string[]): string {
    const mensajeOriginalArray: string[] = mensajeOriginal.split("");
    const diccionario: Map<string, number> = new Map();
    let mensajeCodificado: string = '';
    let numeroPalabra: number = simbolos.length;

    // Primera pasada para crear el diccionario con los valores por defecto
    simbolos.forEach((representacion, index) => {
        diccionario.set(representacion, index);
    });

    // Segunda pasada para crear la salida correspondiente a la codificación
    for (let i = 0; i < mensajeOriginalArray.length; i++) {
        let simbolo = '';
        let salida: string = '';

        for (let j = i; j < mensajeOriginalArray.length; j++) {
            simbolo += mensajeOriginalArray[j];

            if (!diccionario.has(simbolo)) {
                break;
            } else {
                salida = diccionario.get(simbolo)?.toString() || '';
            }
        }

        if (simbolo.length > 1) {
            diccionario.set(simbolo, numeroPalabra);
            numeroPalabra++;
        }

        if (simbolo.length > 2) {
            i++;
        }

        if (i !== mensajeOriginalArray.length - 1) {
            mensajeCodificado += `${salida} `;
        }
    }

    return mensajeCodificado.trim(); // Eliminar espacios innecesarios al final
}


const mensaje: string = 'ABCABDABCBBDACDABBDA',
    simbolos: string[] = ['A','B','C','D'];

console.log(`Se quiere transmitir el mensaje: ${mensaje}`);

const mensajeCodificadoLZW: string = compresorLZW(mensaje,simbolos)
console.log(`Mensaje codificado: ${mensajeCodificadoLZW}`)