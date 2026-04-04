package HoraDeCodar07.relatorios

import AntigoHC07.formatarPreco
import HoraDeCodar07.eventos.AuditoriosRepositorio
import HoraDeCodar07.hospedes.HospedesRepositorio
import HoraDeCodar07.reservas.QuartosRepositorio

object RelatoriosRepositorio {
    var totalReservasConfirmadas: Int = 0
    var qtdQuartosOcupados: Int = 0
    var qtdHospedesCadastrados: Int = 0
    var qtdEventosConfirmados: Int = 0
    var receitaTotalHospedagem: Double = 0.0
    var receitaTotalEventos: Double = 0.0
    var lucroTotal: Double = 0.0

    fun atualizarRelatorio() {
        atualizarQuartosOcupados()
        atualizarHospedesCadastrados()
        atualizarEventosConfirmados()
        atualizarLucroTotal()
    }

    private fun atualizarQuartosOcupados() {
        val quartos = QuartosRepositorio.listarQuartos()
        qtdQuartosOcupados = quartos.count { it.ocupado }
        return
    }

    private fun atualizarHospedesCadastrados() {
        val hospedes = HospedesRepositorio.listarHospedes()
        qtdHospedesCadastrados = hospedes?.count() ?: 0
        return
    }

    private fun atualizarEventosConfirmados() {
        val reservas = AuditoriosRepositorio.listarReservas()
        qtdEventosConfirmados = reservas.count()
        return
    }

    private fun atualizarLucroTotal() {
        lucroTotal = formatarPreco(receitaTotalHospedagem + receitaTotalEventos)
        return
    }
}