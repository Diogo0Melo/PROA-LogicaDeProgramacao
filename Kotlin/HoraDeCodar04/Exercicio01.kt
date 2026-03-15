package HoraDeCodar04

/*
1 - Estudantes.
Crie um programa onde o usuário possa cadastrar estudantes sem limites, e, em seguida, Se o usuário digitar "PARE" o programa deve exibir a quantidade de estudantes cadastrados e a lista com cada um deles.
 */

val estudantes: MutableList<String> = mutableListOf()

private fun main() {
    return cadastrarEstudante()
}

fun cadastrarEstudante() {
    println("Digite \"PARE\" ")
    println("Qual o nome do estudante?")
    val nomeEstudante = readln().trim()
    if (nomeEstudante.uppercase() == "PARE") return imprimirInformacoes()
    else if (nomeEstudante.isNotBlank()) {
        estudantes.add(nomeEstudante)
        return main()
    }
    println("Nome inválido!")
    return cadastrarEstudante()
}

fun imprimirInformacoes() {
    println("Quantidade de estudantes: ${estudantes.size}")
    println("Nomes: $estudantes")
}