package HoraDeCodar07.abastecimento

object PostosRepositorio {
    val postos = listOf(
        Posto("Wayne Oil", 0.0, 0.0),
        Posto("Stark Petrol", 0.0, 0.0)
    )

    fun postoMaisBarato(): Posto = postos.minBy { it.combustivelMaisBarato.values.first() }
}