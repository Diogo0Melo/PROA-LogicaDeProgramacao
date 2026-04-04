package HoraDeCodar08.utils

fun pressEnterToContinue() {
    println("Pressione Enter para continuar...")
    readln()
    return
}

fun wait(action: String, timeToWait: Int) {
    print(action)
    for (i in 1..timeToWait) {
        print(".")
        Thread.sleep(1000)
    }
    println("")
}

fun validateName(name: String): Boolean {
    // Regex permite apenas letras com o mínimo de 3 e no máximo 30 caracteres
    val NAME_REGEX = Regex("""^(?=.{3,30})\p{L}+(?: \p{L}+)*$""")
    return NAME_REGEX.matches(name)
}

fun formatName(name: String): String {
    val formatedName = name.lowercase()
    return formatedName.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
}