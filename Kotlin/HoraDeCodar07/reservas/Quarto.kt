package HoraDeCodar07.reservas

import HoraDeCodar07.hospedes.Hospede

data class Quarto(
    val numero: Int,
    var ocupado: Boolean,
    var diasReservado: Int,
    var classe: String? = null,
    var hospedes: MutableList<Hospede>? = null
) {
    fun estaOcupado(): String = if (ocupado) "Ocupado" else "Livre"

    fun alterarOcupacao() = run { ocupado = !ocupado }

}