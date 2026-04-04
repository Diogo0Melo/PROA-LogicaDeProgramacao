package HoraDeCodar07.ar_condicionado

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.menus.nomeFuncionario
import HoraDeCodar07.utils.pausarFluxo
import HoraDeCodar07.utils.solicitarNome

fun manutencaoArCondicionados() {

    println("MANUTENÇÃO DE AR-CONDICIONADOS")

    val nomeEmpresa = solicitarNome("da empresa")
    val valorPorAparelho = solicitarValorPorAparelho()
    val qtdAparelhos = solicitarQtdAparelhos()
    val porcetangemDesconto = solicitarPorcentagemDesconto()
    val minQtdAparelhosDesconto = solicitarMinQtdAparelhosDesconto()

    val empresa = Empresa(nomeEmpresa, valorPorAparelho, qtdAparelhos, porcetangemDesconto, minQtdAparelhosDesconto)
    val resposta = EmpresasRepositorio.salvarEmpresa(empresa)
    if (resposta) {
        println("O serviço de $nomeEmpresa, custará ${empresa.valorTotal}")
        pausarFluxo()
        return desejaAdicionarMaisEmpresas()
    }
    println("Não foi possível salvar a empresa")
    pausarFluxo()
    return manutencaoArCondicionados()
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
    val empresaMaisBarata = EmpresasRepositorio.calcularEmpresaMaisBarata()
    if(empresaMaisBarata == null){
        println("Não há empresas cadastradas. Retornando ao menu principal.")
        pausarFluxo()
        return inicio()
    }
    println("O orçamento de menor valor é o da ${empresaMaisBarata.nomeEmpresa} por R$${empresaMaisBarata.valorTotal}")
    EmpresasRepositorio.limpar()
    pausarFluxo()
    return inicio()
}