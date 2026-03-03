package HoraDeCodar03

fun main(){
    /*
    Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive). Considere que o N será sempre maior que ZERO.
    N  é um valor informado pelo usuário
     */

    println("Digite o valor final: ")
    val valor:Int = readln().toInt()

    for(i in 1..valor){
        println(i)
    }
}