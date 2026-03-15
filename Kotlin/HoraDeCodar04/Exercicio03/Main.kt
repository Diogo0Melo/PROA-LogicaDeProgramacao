package HoraDeCodar04.Exercicio03

/*
3 - Compras
Vamos criar uma lista de compras.
Crie uma array de frutas, exiba-a ao usuário e, em seguida, peça ao usuário para digitar o nome de uma das frutas.
Caso a fruta esteja no array, remova-a e exiba a mensagem "Fruta foi retirada da lista".
Peça novamente para o usuário digitar o nome de uma fruta para ser removida.
Sempre que o usuário procurar por uma fruta que não está no array exiba a mensagem "Fruta indisponível no nosso mercado".
Quando o array não possuir mais itens dentro de si, escreva "Lista de compras finalizada".
 */

private fun main() {
    exibirFrutas()
    retirarFrutaDaLista()
}

private fun exibirFrutas() {
    val frutasNoIdioma = solicitarIdioma()
    frutasNoIdioma.forEachIndexed { index, fruta ->
        val frutaFormatada = centralizar((fruta) as String)
        if ((index + 1) % 6 == 0) print("$frutaFormatada\n")
        else print("$frutaFormatada | ")
    }
}

private fun solicitarIdioma(): List<Any> {
    println("IDIOMAS\n Portugues, Ingles, Espanhol, Frances, Indonesio, Alemao, Turco, Italiano, Swahili, Tagalog.")
    println("Qual o idioma que você deseja ver as frutas?")
    val idioma = readln().lowercase()
    return FRUTAS.map { fruta ->
        when (idioma) {
            "portugues" -> fruta.portugues
            "ingles" -> fruta.ingles
            "espanhol" -> fruta.espanhol
            "frances" -> fruta.frances
            "indonesio" -> fruta.indonesio
            "alemao" -> fruta.alemao
            "turco" -> fruta.turco
            "italiano" -> fruta.italiano
            "swahili" -> fruta.swahili
            "tagalog" -> fruta.tagalog
            else -> return solicitarIdioma()
        }
    }
}

private fun centralizar(texto: String): String {
    val espacoTotal = 26
    val tamanho = texto.length
    if (tamanho >= espacoTotal) return texto

    val espacosFaltando = espacoTotal - tamanho
    val espacosEsquerda = espacosFaltando / 2
    val espacosDireita = espacosFaltando - espacosEsquerda

    return buildString {
        for (i in 1..espacosEsquerda) append(" ")
        append(texto)
        for (i in 1..espacosDireita) append(" ")
    }
}

private fun retirarFrutaDaLista() {
    println("\nQual fruta você deseja retirar da lista?")
    val frutaEscolhida: String = readln().lowercase()



    for (fruta in FRUTAS) {
        val removerFruta = {
            FRUTAS.remove(fruta)
            println("$frutaEscolhida foi retirada da lista")
            enter()
            main()
        }
        return when {
            fruta.portugues.lowercase() == frutaEscolhida -> removerFruta()
            fruta.ingles.lowercase() == frutaEscolhida -> removerFruta()
            fruta.alemao.lowercase() == frutaEscolhida -> removerFruta()
            fruta.turco.lowercase() == frutaEscolhida -> removerFruta()
            fruta.frances.lowercase() == frutaEscolhida -> removerFruta()
            fruta.espanhol.lowercase() == frutaEscolhida -> removerFruta()
            fruta.indonesio.lowercase() == frutaEscolhida -> removerFruta()
            fruta.italiano.lowercase() == frutaEscolhida -> removerFruta()
            fruta.swahili.lowercase() == frutaEscolhida -> removerFruta()
            fruta.tagalog.lowercase() == frutaEscolhida -> removerFruta()
            else -> continue
        }
    }

    println("$frutaEscolhida não existe na lista")
    enter()
    return main()

}

private fun enter() {
    println("Pressione Enter para continuar...")
    readln()
}