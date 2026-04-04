package HoraDeCodar07.eventos

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.utils.formatarPreco
import HoraDeCodar07.utils.pausarFluxo
import HoraDeCodar07.utils.solicitarNome

fun reservarEspacoEvento() {
    println("RESERVA AUDITÓRIO PARA EVENTO\n")
    val qtdConvidados = solicitarQtdConvidados()
    val auditorio = retornarAuditorio(qtdConvidados)

    println("Agora vamos ver a agenda do evento.")
    pausarFluxo()

    val diaEvento = solicitarDiaEvento(auditorio)
    val horarioEvento = solicitarHorarioEvento(diaEvento)
    val nomeEmpresa = solicitarNome("da empresa")

    println("Auditório reservado para $nomeEmpresa. $diaEvento às ${horarioEvento}h.")
    pausarFluxo()

    val duracaoEvento = solicitarDuracaoEvento(diaEvento, horarioEvento)
    val garcons = Garcom(10.5, qtdConvidados, duracaoEvento)
    println("São necessários ${garcons.quantidade} garçons.")
    println("Custo: R$${garcons.custoTotal}")

    println("Agora vamos calcular o custo do buffet do hotel para o evento.")
    pausarFluxo()

    val cafe = Item("Café", 0.8, qtdConvidados, 0.2)
    val agua = Item("Água", 0.4, qtdConvidados, 0.5)
    val salgado = Item("Salgado", 0.34, qtdConvidados, 7.0)
    val custoBuffet = formatarPreco(cafe.custoTotal + agua.custoTotal + salgado.custoTotal)

    println("O evento precisará de ${cafe.quantidade} litros de café, ${agua.quantidade} litros de água, ${salgado.quantidade} salgados.")
    pausarFluxo()

    println("Evento no ${auditorio.nome}")
    println("Nome da Empresa: $nomeEmpresa")
    println("Data: $diaEvento, ${horarioEvento}h às ${horarioEvento + duracaoEvento}h")
    println("Duração do evento: ${duracaoEvento}h")
    println("Quantidade de garçons: ${garcons.quantidade}")
    println("Quantidade de Convidados: $qtdConvidados")

    println("\nCusto dos garçons: R$${garcons.custoTotal}")
    println("Custo do Buffet: R$${custoBuffet}")

    println("\nValor total do Evento: ${formatarPreco(garcons.custoTotal + custoBuffet)}")
    pausarFluxo()

    return confirmarReserva(auditorio, diaEvento)
}

fun solicitarQtdConvidados(): Int {
    println("Qual o número de convidados para o seu evento?")
    val qtdConvidados = readln().toIntOrNull()
    return if (qtdConvidados != null && qtdConvidados in 1..350) {
        qtdConvidados
    } else {
        println("Número de convidados inválido")
        pausarFluxo()
        solicitarQtdConvidados()
    }
}

fun retornarAuditorio(qtdConvidados: Int): Auditorio {
    return when (qtdConvidados) {
        in 1..220 -> {
            val cadeirasExtras = if (qtdConvidados > 150) "inclua mais ${qtdConvidados - 150} cadeiras" else ""
            println(
                "Use o auditório Laranja ($cadeirasExtras)"
            )
            AuditoriosRepositorio.auditorios[0]
        }

        in 221..350 -> {
            println("Use o auditório Colorado")
            AuditoriosRepositorio.auditorios[1]
        }

        else -> throw IllegalArgumentException("NÃO DEVERIA CHEGAR AQUI")
    }
}

fun solicitarDiaEvento(auditorio: Auditorio): String {
    for (i in 0..6) {
        if (i < DiasUteis.entries.size) print("${DiasUteis.entries[i].name.lowercase()}; ")
        else print("${DiasFimDeSemana.entries[i - DiasUteis.entries.size].name.lowercase()}; ")
    }
    println("\nQual o dia do seu evento?")
    val diaEvento = readln().lowercase()

    return if (auditorio.reservas.contains(diaEvento)) {
        println("Auditório indisponível")
        solicitarDiaEvento(auditorio)
    } else if (DiasUteis.entries.any { it.name.lowercase() == diaEvento } || DiasFimDeSemana.entries.any { it.name.lowercase() == diaEvento }) diaEvento
    else {
        println("Dia inválido!")
        solicitarDiaEvento(auditorio)
    }
}

fun solicitarHorarioEvento(diaEvento: String): Int {
    println("Qual é a hora do evento?")
    val horarioEvento = readln().toIntOrNull() ?: -1
    return when {
        DiasUteis.entries.any { it.name.lowercase() == diaEvento } -> {
            if (horarioEvento in 7..23) horarioEvento
            else {
                println("De segunda a sexta os auditórios só funcionam das 7h às 23h")
                solicitarHorarioEvento(diaEvento)
            }
        }

        DiasFimDeSemana.entries.any { it.name.lowercase() == diaEvento } -> {
            if (horarioEvento in 7..15) horarioEvento
            else {
                println("No fim de semana os auditórios só funcionam das 7h às 15h")
                solicitarHorarioEvento(diaEvento)
            }
        }

        else -> {
            println("Horário inválido!")
            solicitarHorarioEvento(diaEvento)
        }
    }
}

fun solicitarDuracaoEvento(diaEvento: String, horarioEvento: Int): Int {
    println("Qual a duração do evento em horas?")
    val duracaoEvento = readln().toIntOrNull()

    if (duracaoEvento == null || DiasUteis.entries.any { it.name.lowercase() == diaEvento } && (horarioEvento + duracaoEvento) > 23) {
        println("Duração inválida! Em dias úteis o evento só pode ir até as 23h")
        return solicitarDuracaoEvento(diaEvento, horarioEvento)
    } else if (DiasFimDeSemana.entries.any { it.name.lowercase() == diaEvento } && (horarioEvento + duracaoEvento) > 15) {
        println("Duração inválida! No fim de semana o evento só pode ir até as 15h")
        return solicitarDuracaoEvento(diaEvento, horarioEvento)
    }
    return duracaoEvento

}

fun confirmarReserva(auditorio: Auditorio, diaReserva: String) {
    println("Gostaria de efetuar a reserva? S/N")
    val escolha = readln().uppercase()

    return when (escolha) {
        "S" -> reservaConfirmada(auditorio, diaReserva)
        "N" -> reservaCancelada()
        else -> confirmarReserva(auditorio, diaReserva)
    }
}

fun reservaConfirmada(auditorio: Auditorio, diaReserva: String) {
    val resposta = AuditoriosRepositorio.salvarReserva(auditorio, diaReserva)
    if(resposta) {
        println("Reserva efetuada com sucesso!")
    }
    pausarFluxo()
    return inicio()
}


fun reservaCancelada() {
    println("Reserva não efetuada.")
    pausarFluxo()
    return inicio()
}
