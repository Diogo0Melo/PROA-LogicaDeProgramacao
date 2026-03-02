package HoraDeCodar02

fun main() {
    /*
    Escreva um programa que calcule a média de quatro números informados pelo usuário, mas somente se esses números forem maiores que 0 e menores que 10. No final, se a média for maior que cinco o usuário receberá uma mensagem "Você passou no teste". Em qualquer outra situação, ele receberá uma mensagem de "tente novamente"
     */

    var media: Double = 0.0

    for (i in 1..4) {
        do {
            print("Digite a ${i}º nota: ")
            val valorInformado: Double = readln().toDouble()
            if (valorInformado in 1.0..9.0) media += valorInformado
            else println("Nota inválida! Digite um valor entre 1 e 9.")
        } while (valorInformado !in 1.0..9.0)
    }
    if (media / 4 > 5) println("Você passou no teste")
    else println("Tente novamente")
}