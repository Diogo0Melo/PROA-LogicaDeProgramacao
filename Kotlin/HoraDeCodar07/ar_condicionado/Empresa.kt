package HoraDeCodar07.ar_condicionado

import HoraDeCodar07.utils.formatarPreco

data class Empresa(
    val nomeEmpresa: String,
    val valorPorAparelho: Double,
    val qtdAparelhos: Int,
    val porcetangemDesconto: Int,
    val minQtdAparelhosDesconto: Int,
    val valorDeslocamento: Double = 150.0
) {
    val valorTotal: Double = formatarPreco(calcularValorTotal())

    fun calcularValorTotal(): Double {
        val subTotal = this.valorPorAparelho * this.qtdAparelhos
        if (this.qtdAparelhos >= this.minQtdAparelhosDesconto) {
            return subTotal - (subTotal * (this.porcetangemDesconto / 100.0))
        }
        return subTotal + valorDeslocamento
    }
}