package HoraDeCodar07.eventos

import HoraDeCodar07.utils.formatarPreco

interface CustosEvento {

    val nome: String
    val quantidade: Int
    val custo: Double
    val custoTotal: Double

    fun calcularCustoTotal(): Double {
        return formatarPreco(this.custo * this.quantidade)
    }
}