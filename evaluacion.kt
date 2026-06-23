val participantes = mutableListOf<String>()
val puntosParticipantes = mutableListOf<MutableList<Double>>()

val categoria = arrayOf(
    "Leyenda",
    "Experto",
    "Competidor",
    "Novato"
)

fun main(){
    while (true){
        menuMostrar()
        when(readln().toInt()){
            1-> registarParticipante()
            2-> registrarPuntos()
    }

}
}

fun menuMostrar(){
    println("""
        ===== Sistema de Registros del Torneo =====
        
        1. Registrar participante
        2. Registrar puntos
        3. Consultar participante
        4. Mostrar estadísticas del torneo
        5. Finalizar programa 
        
        
        Seleccione una opción, porfavor:   
    """.trimIndent())
}

fun registarParticipante(){
    println("Ingrese el nombre del participante: ")
    val nombre = readln()

    if(nombre.isEmpty()){
        println("Error, no puede haber datos vacios")
        return
    }

    if(participanteExistente(nombre)){
        println("Este participante ya está registrado")
        return
    }


    participantes.add(nombre)
    puntosParticipantes.add(mutableListOf())

    println("Participante registrado")




}

fun participanteExistente(nombre: String): Boolean{
    return participantes.contains(nombre)
}




fun registrarPuntos() {
    if (participantes.isEmpty()) {
        println("No hay participantes registrados")
        return
    }

    println("Participantes")
    for (i in participantes) {
        println(i)
    }

    println("Nombre del participante: ")
    val nombre = readln()

    if(participanteExistente(nombre)) {
        println("Lo sentimos participante no encontrado ")

    }

    while(true){
        println("Registre los puntos: ")
        val puntos = readln().toInt()
        if (puntos <= 0){
            println("No podemos registar esos puntos ")
            continue
        }
        val index = participantes.indexOf(nombre)
        puntosParticipantes[index].add(puntos.toDouble())
        println("Hemos registrado sus puntos")
        break
    }
    }

fun consultarParticipante(){
    println("Nomnre del participante: ")
    val nombre = readln()

    if(participanteExistente(nombre)){
        println("Lo sentimos participante no encontrado ")
        return
    }
    val index = participantes.indexOf(nombre)
    val puntos = puntosParticipantes[index]

    var totalpuntos = 0.0
    for (i in puntos) {
        totalpuntos += i

    }

    val categoria= categoria(totalpuntos)

    println("""
        Nombre: $nombre
        Total de puntos: $totalpuntos
        Categoria: $categoria
        
    """.trimIndent())


}


fun categoria(totalpuntos: Double): String {
    when {
        totalpuntos >= 1000 -> "Leyenda"
        totalpuntos >= 500 and 999 -> "Experto"
        totalpuntos >= 200 and 499 -> "Competidor"
        totalpuntos <= 200 -> "Novato"


    }
    return TODO("Provide the return value")
}


