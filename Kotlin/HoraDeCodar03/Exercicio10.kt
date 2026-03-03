package HoraDeCodar03

fun main(){
    /*
    Escreva um programa em que o usuário informe 10 valores e escreva quantos desses valores lidos estão entre os números 24 e 42 (incluindo os valores 24 e 42) e quantos deles estão fora deste intervalo.
     */

    val valores = DoubleArray(10)
    var valoresDentro = 0; var valoresFora = 0
    valores.forEachIndexed { index, d ->
        println("Digite o ${index+1}º valor: ")
        val valor = readln().toInt()
        if(valor in 24..42) valoresDentro++
        else valoresFora++
    }
    println("Valores entre 24 e 42: $valoresDentro")
    println("Valores fora do range: $valoresFora")

}