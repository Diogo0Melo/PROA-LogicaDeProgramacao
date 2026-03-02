package HoraDeCodar02

fun main() {
    /*
     Faça um programa que leia 6 valores informados pelo usuário, calcule, exiba
     os números informados e escreva a média aritmética desses valores lidos.
     */

    val valores = DoubleArray(6)
    valores.mapIndexed { index, valor ->
        print("Digite o ${index + 1}º valor: ")
        valores[index] = readln().toDouble()
        if (index == valores.size - 1) {
            valores.forEach { valor -> print("${valor} ") }
            println("\nA média aritmética dos valores acima é ${"%.2f".format(valores.sum() / valores.size)}")
        }
    }
}