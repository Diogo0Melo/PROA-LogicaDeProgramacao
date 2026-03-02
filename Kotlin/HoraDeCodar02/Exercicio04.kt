package HoraDeCodar02

fun main() {
    /*
    Faça um programa que leia 3 valores informados pelo usuário
    (considere que não serão informados valores iguais) e
    escrever a soma dos 2 maiores.
     */

    val valores = DoubleArray(3)
    valores.forEachIndexed { index, valor ->
        print("Digite o ${index + 1}º valor: ")
        valores[index] = readln().toDouble()
    }
    valores.sort()
    val resultado = valores[valores.size-1] + valores[valores.size-2]
    println("O resultado da soma dos 2 maiores valores é $resultado")
}