package HoraDeCodar07.eventos

import kotlin.math.ceil

class Garcom(override val custo: Double, qtdConvidados: Int, duracaoEvento: Int) : CustosEvento {
    override val nome: String = "Serviço de Garçom"
    override val quantidade: Int = calcularQtd(qtdConvidados, duracaoEvento)
    override val custoTotal: Double = calcularCustoTotal()

    fun calcularQtd(qtdConvidados: Int, duracaoEvento: Int): Int {
        var qtd = ceil(qtdConvidados / 12.0).toInt()
        for (i in 1..duracaoEvento) if (i % 2 == 0) qtd++
        return qtd
    }

}