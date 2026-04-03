package HoraDeCodar07.reservas

import HoraDeCodar07.hospedes.Hospede

object QuartosRepositorio {
    val listaQuartos = Array(20) { index -> Quarto(index + 1, false, 0) }

    fun salvarReserva(quarto: Quarto, hospedes: MutableList<Hospede>, qtdDiarias: Int): Boolean {
        if (quarto.ocupado) return false
        quarto.hospedes = hospedes
        quarto.alterarOcupacao()
        quarto.diasReservado = qtdDiarias
        return true
    }

    fun pesquisarQuarto(numero: Int): Quarto = listaQuartos.find { it.numero == (numero) }!!

    fun listarQuartosDisponiveis(): List<Quarto> = listaQuartos.filter { !it.ocupado }

    fun listarQuartos(): List<Quarto> = listaQuartos.map { it }
}
