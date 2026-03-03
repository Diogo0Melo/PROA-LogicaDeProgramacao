package HoraDeCodar03

fun main(){
  /*
  Faça um algoritmo que calcule e escreva a média aritmética dos dois números inteiros informados pelo usuário e todos os números inteiros entre eles. Considere que o primeiro sempre será menor que o segundo.
   */

    println("Digite o primeiro número: ")
    val valor1 = readln().toInt()

    println("Digite o segundo número: ")
    val valor2 = readln().toInt()

    var divisor: Int = 0
    var soma: Int = 0

    for (i in valor1..valor2){
        divisor++
        soma += i
    }

    println("A média aritimética da soma dos valores entre $valor1 e $valor2 é ${soma/divisor}")
}