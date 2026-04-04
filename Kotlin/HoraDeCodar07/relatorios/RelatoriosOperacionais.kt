package HoraDeCodar07.relatorios

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.utils.pausarFluxo

fun relatoriosOperacionais() {

    RelatoriosRepositorio.atualizarRelatorio()

    println("RELATÓRIOS OPERACIONAIS\n")
    println("-------------------------------------------------------------------------------------")
    println("Total de reservas de quartos confirmadas: ${RelatoriosRepositorio.totalReservasConfirmadas}")
    println("Taxa de ocupação atual: ${RelatoriosRepositorio.qtdQuartosOcupados} / 20")
    println("Quatidade de hóspedes cadastrados: ${RelatoriosRepositorio.qtdHospedesCadastrados}")
    println("Quantidade de eventos confirmados: ${RelatoriosRepositorio.qtdEventosConfirmados}")
    println("-------------------------------------------------------------------------------------")
    println("Receitas Acumuladas:")
    println("Receita com hospedagem: R$${RelatoriosRepositorio.receitaTotalHospedagem}")
    println("Receita com eventos: R$${RelatoriosRepositorio.receitaTotalEventos}")
    println("Receita total: R$${RelatoriosRepositorio.lucroTotal}\n")

    pausarFluxo()
    return inicio()

}