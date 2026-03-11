package HoraDeCodar07.ExerciciosSeparados

// 6) Ar puro, finalmente.

class Empresa(
    val nomeEmpresa: String,
    val valorPorAparelho: Double,
    val qtdAparelhos: Int,
    val porcetangemDesconto: Int,
    val minQtdAparelhosDesconto: Int
) {

    val valorTotal: Double = calcularValorTotal()

    fun calcularValorTotal(): Double {
        val valorTotal = this.valorPorAparelho * this.qtdAparelhos
        if (this.qtdAparelhos >= this.minQtdAparelhosDesconto) {
            return valorTotal - (valorTotal * (this.porcetangemDesconto / 100.0))
        }
        return valorTotal

    }
}

val empresas: MutableList<Empresa> = mutableListOf()

fun manutencaoArCondicionados() {

    println("MANUTENÇÃO DE AR-CONDICIONADOS")

    val nomeEmpresa = solicitarNomeEmpresa()
    val valorPorAparelho = solicitarValorPorAparelho()
    val qtdAparelhos = solicitarQtdAparelhos()
    val porcetangemDesconto = solicitarPorcentagemDesconto()
    val minQtdAparelhosDesconto = solicitarMinQtdAparelhosDesconto()

    val empresa = Empresa(nomeEmpresa, valorPorAparelho, qtdAparelhos, porcetangemDesconto, minQtdAparelhosDesconto)
    empresas.add(empresa)

    println("O serviço de $nomeEmpresa, custará ${"%.2f".format(empresa.valorTotal)}")
    enter()

    return desejaAdicionarMaisEmpresas()
}

fun solicitarValorPorAparelho(): Double {
    println("Qual o valor por aparelho? ")
    val valorPorAparelho = readln().toDoubleOrNull() ?: 0.0
    if (valorPorAparelho <= 0.0) return solicitarValorPorAparelho()
    return valorPorAparelho
}

fun solicitarQtdAparelhos(): Int {
    println("Qual a quantidade de aparelhos?")
    val qtdAparelhos = readln().toIntOrNull() ?: 0
    if (qtdAparelhos <= 0) return solicitarQtdAparelhos()
    return qtdAparelhos
}

fun solicitarPorcentagemDesconto(): Int {
    println("Qual a porcentagem de desconto?")
    val porcetangemDesconto = readln().toIntOrNull() ?: -1
    if (porcetangemDesconto !in 0..100) return solicitarPorcentagemDesconto()
    return porcetangemDesconto
}

fun solicitarMinQtdAparelhosDesconto(): Int {
    println("Qual o número mínimo de aparelhos para conseguir o desconto?")
    val minQtdAparelhosDesconto = readln().toIntOrNull() ?: -1
    if (minQtdAparelhosDesconto < 0) return solicitarMinQtdAparelhosDesconto()
    return minQtdAparelhosDesconto
}

fun desejaAdicionarMaisEmpresas() {
    println("Deseja informar novos dados, $nomeFuncionario? (S/N)")
    val opcao = readln().uppercase()
    return when (opcao) {
        "S" -> manutencaoArCondicionados()
        "N" -> definirEmpresaBarata()
        else -> desejaAdicionarMaisEmpresas()
    }
}

fun definirEmpresaBarata() {
    val empresaMaisBarata = empresas.minBy { it.valorTotal }
    println("O orçamento de menor valor é o da ${empresaMaisBarata.nomeEmpresa} por R$${"%.2f".format(empresaMaisBarata.valorTotal)}")
    enter()
    return inicio()
}