package HoraDeCodar07.hospedes

import HoraDeCodar07.reservas.Quarto
import HoraDeCodar07.utils.formatarDataHora
import java.time.LocalDateTime

data class Hospede(var nome: String, var quarto: Quarto? = null) {
    val dataCadastro: String = formatarDataHora(LocalDateTime.now())

    init {
        println("$nome cadastrado(a) com sucesso.")
    }
}