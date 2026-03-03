package HoraDeCodar03

fun main() {
    /*
     Escreva um programa para imprimir todas as tabuadas de 1 a N. N será informado pelo usuário.
     */

    println("Digite o valor da última tabuada: ")
    val valorUltimaTabuada: Int = readln().toInt()

    println("Digite o valor final que as tabuadas serão multiplicadas: ")
    val valorMultiplicacao: Int = readln().toInt()

    for (i in 1..valorUltimaTabuada){
        for (j in 1..valorMultiplicacao){
            println("$i X $j = ${i * j}")
        }
        println("---")
    }

}

