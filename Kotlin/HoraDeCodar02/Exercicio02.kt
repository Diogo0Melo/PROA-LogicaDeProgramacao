package HoraDeCodar02

fun main(){
    /*
    Faça um programa que leia um valor
    informado pelo usuário e diga se o valor
    informado é positivo, negativo ou zero.
     */

    print("Digite um número: ")
    val valor = readln().toDouble()
    when {
        valor > 0 -> println("O número digitado é positivo")
        valor < 0 -> println("O número digitado é negativo")
        else -> println("O número digitado é zero")
    }
}