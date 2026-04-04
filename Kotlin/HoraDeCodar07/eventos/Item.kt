package HoraDeCodar07.eventos

import kotlin.math.ceil

class Item(override val nome: String, override val custo: Double, qtdConvidados: Int, consumoPorPessoa: Double) :
    CustosEvento {

    override var quantidade: Int = calcularQtd(qtdConvidados, consumoPorPessoa)
    override var custoTotal: Double = calcularCustoTotal()

    fun calcularQtd(qtdConvidados: Int, consumoPorPessoa: Double): Int {
        return ceil(qtdConvidados * consumoPorPessoa).toInt()
    }

}