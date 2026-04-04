package HoraDeCodar07.reservas

fun listarQuartosDisponiveis() {
    println("QUARTOS DISPONIVEIS NO HOTEL\n")
    val quartos = QuartosRepositorio.listarQuartosDisponiveis()
    quartos.forEach { quarto ->
        println("Quarto ${quarto.numero}: ${quarto.estaOcupado()} - Dias reservado: ${quarto.diasReservado} - Hóspedes: ${quarto.hospedes?.joinToString { it.nome } ?: "Nenhum"}")
    }
}

fun listarQuartos() {
    println("QUARTOS DO HOTEL\n")
    val quartos = QuartosRepositorio.listarQuartos()
    quartos.forEach { quarto ->
        println("Quarto ${quarto.numero}: ${quarto.estaOcupado()} - Dias reservado: ${quarto.diasReservado} - Hóspedes: ${quarto.hospedes?.joinToString { it.nome } ?: "Nenhum"}")
    }
}