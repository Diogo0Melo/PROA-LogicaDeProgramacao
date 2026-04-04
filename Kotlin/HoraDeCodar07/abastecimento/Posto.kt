package HoraDeCodar07.abastecimento

data class Posto(
    val nome: String,
    var precoAlcool: Double,
    var precoGasolina: Double
) {
    lateinit var combustivelMaisBarato: Map<String, Double>

    fun calcularMelhorPrecoCombustivel() {
        combustivelMaisBarato = if (precoAlcool <= precoGasolina * 0.7) {
            mapOf("Álcool" to precoAlcool)
        } else {
            mapOf("Gasolina" to precoGasolina)
        }
    }

}

