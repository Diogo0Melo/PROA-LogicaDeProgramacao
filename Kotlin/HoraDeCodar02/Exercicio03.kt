package HoraDeCodar02

fun main() {

    /*
    Faça um programa para ler 3 valores (considere que não
    serão informados valores iguais) e escrever o maior deles.
     */
    var maiorValor: Double? = null
    for (i in 0..<3) {
        print("Digite o ${i + 1}º valor: ")
        val valor = readln().toDouble()
        if (maiorValor == null) maiorValor = valor
        else if (valor > maiorValor) maiorValor = valor
    }
    println("O maior valor digitado foi ${maiorValor}")
}

