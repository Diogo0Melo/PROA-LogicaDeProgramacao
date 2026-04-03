package HoraDeCodar07.reservas

import HoraDeCodar07.hospedes.Hospede
import HoraDeCodar07.hospedes.HospedesRepositorio
import HoraDeCodar07.hospedes.listarHospedesSemReserva
import HoraDeCodar07.menus.inicio
import HoraDeCodar07.menus.nomeFuncionario
import HoraDeCodar07.utils.formatarPreco
import HoraDeCodar07.utils.pausarFluxo

fun reservarQuarto() {
    println("RESERVA DE QUARTO\n")
    val valorDiaria = solicitarValorDiaria() ?: return inicio()
    val qtdDiarias = solicitarQtdDiarias() ?: return inicio()
    val classeQuarto = solicitarClasseDoQuarto() ?: return inicio()
    val subTotal = calcularSubTotal(valorDiaria, qtdDiarias, classeQuarto)
    val taxaServico = formatarPreco(subTotal * 0.1) // 10% de taxa de serviço
    val total = formatarPreco(subTotal + taxaServico)

    val listaHospedes = selecionarHospedes().ifEmpty { return inicio() }
    val quartoSelecionado = selecionarQuarto()

    confirmarReserva(
        valorDiaria,
        qtdDiarias,
        listaHospedes,
        quartoSelecionado,
        classeQuarto,
        subTotal,
        taxaServico,
        total
    )

    listarQuartos()
    pausarFluxo()
    return inicio()
}


fun solicitarValorDiaria(): Double? {
    println("Digite o valor da diária: ")
    val valor = readln().toDoubleOrNull()
    if (valor == null || valor <= 0) {
        println("Valor inválido. Por favor, digite um valor positivo.")
        return null
    }
    return formatarPreco(valor)
}

fun solicitarQtdDiarias(): Int? {
    println("Digite a quantidade de diárias: ")
    val qtd = readln().toIntOrNull()
    if (qtd == null || qtd <= 0 || qtd > 30) {
        println("Quantidade inválida. Por favor, digite um número positivo e de até 30 dias.")
        return null
    }
    return qtd
}

fun solicitarClasseDoQuarto(): String? {
    println("Digite a classe do quarto (standard, executive ou luxo): ")
    val classe = readln()
    if (classe.uppercase() !in listOf("STANDARD", "EXECUTIVE", "LUXO")) {
        println("Classe inválida. Por favor, digite uma classe válida.")
        return null
    }
    return classe.lowercase()
}

fun calcularSubTotal(
    valorDiaria: Double,
    qtdDiarias: Int,
    classeQuarto: String
): Double {
    val subTotal = (valorDiaria * qtdDiarias)
    return when (classeQuarto) {
        "standard" -> formatarPreco(subTotal)
        "executive" -> formatarPreco(subTotal * 1.35)
        "luxo" -> formatarPreco(subTotal * 1.65)
        else -> throw IllegalArgumentException("NUNCA DEVERIA CHEGAR AQUI")
    }
}

fun selecionarHospedes(): MutableList<Hospede> {
    val listaHospedes = mutableListOf<Hospede>()
    while (true) {
        println("Digite o nome do hóspede para adicionar à reserva ou \"FIM\" para finalizar a seleção: ")
        val nomeHospede = readln()
        if (nomeHospede.uppercase() == "FIM") {
            if (listaHospedes.isEmpty()) {
                println("Nenhum hóspede selecionado. Você retornará ao menu principal.")
                return listaHospedes
            }

            return listaHospedes
        } else if (listaHospedes.size == 15) {
            println("Limite máximo de 15 hóspedes por reserva/quarto atingido. Por favor encerre os registros.")
            pausarFluxo()
            continue
        }
        val hospede = HospedesRepositorio.pesquisarPorNomeExato(nomeHospede)
        if (hospede != null) {
            listaHospedes.add(hospede)
            println("$nomeHospede adicionado à reserva.")
        } else {
            println("Hóspede não encontrado. Por favor, digite um nome válido ou cadastre o hóspede antes de selecioná-lo.")
            listarHospedesSemReserva()
        }
    }
}

fun selecionarQuarto(): Quarto {
    println("Selecione um quarto disponível (1-20): ")
    val numeroQuarto = readln().toIntOrNull()
    if (numeroQuarto == null || numeroQuarto < 1 || numeroQuarto > 20) {
        println("Número de quarto inválido. Por favor, selecione um número entre 1 e 20.")
        return selecionarQuarto()
    }
    val quarto = QuartosRepositorio.pesquisarQuarto(numeroQuarto)
    if (quarto.ocupado) {
        println("O quarto $numeroQuarto já está ocupado. Por favor, selecione outro quarto.")
        QuartosRepositorio.listarQuartosDisponiveis()
        listarQuartosDisponiveis()
        pausarFluxo()
        return selecionarQuarto()
    }
    println("Quarto $numeroQuarto selecionado com sucesso!")
    pausarFluxo()
    return quarto
}

fun confirmarReserva(
    valorDiaria: Double,
    qtdDiarias: Int,
    hospedes: MutableList<Hospede>,
    quartoSelecionado: Quarto,
    classeQuarto: String,
    subTotal: Double,
    taxaServico: Double,
    total: Double
) {
    println("Resumo: ")
    println("Hóspedes: ${listarHospedesSelecionados(hospedes)}")
    println("Quarto: ${quartoSelecionado.numero} ($classeQuarto)")
    println("Subtotal: R$$subTotal")
    println("Taxa de serviço (10%): R$$taxaServico")
    println("Total: R$$total")
    println("$nomeFuncionario, confirmar a reserva? (S/N)")
    val opcao = readln().uppercase()
    when (opcao) {
        "S" -> {
            QuartosRepositorio.salvarReserva(quartoSelecionado, hospedes, qtdDiarias)
            hospedes.forEach { HospedesRepositorio.adicionarQuarto(it, quartoSelecionado) }
            println("Hospedagem confirmada para ${hospedes.size} hospede(s) no quarto ${quartoSelecionado.numero} por $qtdDiarias dias. Valor total: R$${total}")
            return
        }

        "N" -> {
            println("Reserva cancelada. Retornando ao menu principal.")
            pausarFluxo()
            return inicio()
        }

        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            pausarFluxo()
            return confirmarReserva(
                valorDiaria,
                qtdDiarias,
                hospedes,
                quartoSelecionado,
                classeQuarto,
                subTotal,
                taxaServico,
                total
            )
        }
    }
}

fun listarHospedesSelecionados(hospedes: List<Hospede>): String = hospedes.joinToString { it.nome }

