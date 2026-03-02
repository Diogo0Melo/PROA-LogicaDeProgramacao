package HoraDeCodar02

fun main(){
    /*
    Tendo como entrada a altura e o gênero designado ao nascer (codificado da seguinte forma: 1: feminino - 2: masculino - ) de uma pessoa, construa um programa que calcule e imprima seu peso ideal, utilizando as seguintes fórmulas.
     */
    println("1: Feminino - 2: Masculino")
    print("Qual o seu gênero de nascimento: ")
    val genero: Int = readln().toInt()
    print("Qual a sua altura: ")
    val altura: Double = readln().toDouble()
    when (genero) {
        1 -> println("Seu peso ideal é: ${"%.2f".format((62.1 * altura) - 44.7)}kg")
        2 -> println("Seu peso ideal é: ${"%.2f".format((72.7 * altura) - 58)}kg")
        else -> println("Opção Inválida! Até a próxima.")
    }
}