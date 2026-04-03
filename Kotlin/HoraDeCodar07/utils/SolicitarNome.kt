package HoraDeCodar07.utils

fun solicitarNome(mensagem: String): String {
    println("Informe o nome $mensagem:")
    val nome = readln()
    return if (validarNome(nome)) formatarNome(nome)
    else {
        println("Nome inválido. Por favor, tente novamente.")
        pausarFluxo()
        solicitarNome(mensagem)
    }
}