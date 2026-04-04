package HoraDeCodar07.abastecimento

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.menus.nomeFuncionario
import HoraDeCodar07.utils.formatarPreco
import HoraDeCodar07.utils.pausarFluxo

fun abastecimentoDeAutomoveis() {
    PostosRepositorio.postos.forEach { posto ->
        println("Qual o valor do álcool no posto ${posto.nome}?")
        val valorAlcool: Double? = readln().toDoubleOrNull()
        println("Qual o valor da gasolina no posto ${posto.nome} ")
        val valorGasolina: Double? = readln().toDoubleOrNull()
        if (valorAlcool == null || valorGasolina == null || valorAlcool <= 0.0 || valorGasolina <= 0.0) {
            println("Favor informar valores válidos")
            pausarFluxo()
            return abastecimentoDeAutomoveis()
        }
        posto.precoAlcool = formatarPreco(valorAlcool)
        posto.precoGasolina = formatarPreco(valorGasolina)
        posto.calcularMelhorPrecoCombustivel()
    }

    PostosRepositorio.postos.forEach { posto ->
        val melhorOpcaoCombustivel = posto.combustivelMaisBarato.keys.first()
        val custoTotalAbastecimento = formatarPreco(posto.combustivelMaisBarato.values.first() * 42)
        println("${posto.nome} melhor opção = $melhorOpcaoCombustivel  | Total (42L) = R$$custoTotalAbastecimento")
    }

    val postoMaisBarato = PostosRepositorio.postoMaisBarato()
    val melhorOpcaoCombustivel = postoMaisBarato.combustivelMaisBarato.keys.first()

    println("${nomeFuncionario}, é mais barato abastecer com $melhorOpcaoCombustivel no posto ${postoMaisBarato.nome}")
    pausarFluxo()
    return inicio()

}