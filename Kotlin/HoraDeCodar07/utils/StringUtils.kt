package HoraDeCodar07.utils

fun validarNome(nome: String): Boolean {
    // Regex permite apenas letras com o mínimo de 3 e no máximo 50
    val NOME_REGEX = Regex("""^(?=.{3,30})\p{L}+(?: \p{L}+)*$""")
    return NOME_REGEX.matches(nome)
}

fun formatarNome(nome: String): String {
    val nomeFormatado = nome.lowercase()
    return nomeFormatado.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
}
