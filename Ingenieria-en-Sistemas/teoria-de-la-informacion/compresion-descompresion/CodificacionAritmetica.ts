interface Simbolo {
  simbolo: string;
  probabilidadAcumulada: number;
}

function codificadorAritmetico(mensajeOriginal: string, probabilidadesAcumuladas: Array<Simbolo>): number {
    let lim_inf: number = 0,
        lim_sup: number = 1;
    for(const simbolo of mensajeOriginal){
        const prob_acum = obtenerRangoProbabilidad(probabilidadesAcumuladas,simbolo);
        const rango: number = lim_sup - lim_inf;
        lim_sup = lim_inf + rango * prob_acum[1];
        lim_inf = lim_inf + rango * prob_acum[0];
    }
    //Se puede transmitir cualquier numero entre [lim_inf,lim_sup)
    //y se debe transmitir la longitud del mensaje ya que el decodificador
    //debe saber cuando cortar el algoritmo}
    return parseFloat(lim_inf.toFixed(3));
}
function decodificadorAritmetico(long: number, numeroCodificado: number,probabilidadesAcumuladas: Array<Simbolo>): string{
    return '';
}
function obtenerRangoProbabilidad(probs: Array<Simbolo>,simbolo: string): Array<number>{
    for(let i = 0; i < probs.length; i++){
        if (simbolo == probs[i].simbolo){
            return i === 0
                ?[0,probs[i].probabilidadAcumulada]
                :[probs[i - 1].probabilidadAcumulada,probs[i].probabilidadAcumulada]
        }
    }
    return [];
} 

const mensajeOriginal: string = 'BAC',
    probAcum: Array<Simbolo> = [
        {simbolo: 'A',probabilidadAcumulada: 0.2},
        {simbolo: 'B',probabilidadAcumulada: 0.6},
        {simbolo: 'C',probabilidadAcumulada: 1}];

let mensajeCodificado: number = codificadorAritmetico(mensajeOriginal,probAcum);

console.log(`Se codifico el mensaje: ${mensajeOriginal}` )
console.log(`Se va a transmitir al decodificador el mensaje:${mensajeOriginal.length} ${mensajeCodificado}`)


let mensajeDecodificado: string = decodificadorAritmetico(3,mensajeCodificado,probAcum)