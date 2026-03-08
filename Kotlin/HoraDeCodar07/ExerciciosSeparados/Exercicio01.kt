package HoraDeCodar07.ExerciciosSeparados

// 1) Quantos quartos são?

fun reservarQuarto() {
    println("RESERVA DE QUARTO\n")
    val valorDiaria = solicitarValorDiaria()
    val qtdDiasHospedagem = solicitarQtdDiasHospedagem()

    println("O valor de $qtdDiasHospedagem dias de hospedagem é de R$${"%.2f".format(valorDiaria * qtdDiasHospedagem)}")
    enter()

    val nomeHospede = solicitarNomeHospede()
    val quartoReservado = solicitarQuartoDisponivel()

    return confirmarHospedagem(nomeHospede, quartoReservado, valorDiaria, qtdDiasHospedagem)
}

fun solicitarValorDiaria(): Double {
    println("Qual o valor padrão da diária? ")
    val valorDiaria = readln().toDoubleOrNull()
    return if (valorDiaria != null && valorDiaria > 0) {
        valorDiaria
    } else {
        println("Valor inválido. $nomeFuncionario")
        solicitarValorDiaria()
    }
}

fun solicitarQtdDiasHospedagem(): Int {
    println("Quantas diárias serão necessárias? ")
    val qtdDiasHospedagem = readln().toIntOrNull()
    return if (qtdDiasHospedagem != null && qtdDiasHospedagem in 1..30) {
        qtdDiasHospedagem
    } else {
        println("Quantidade inválida. $nomeFuncionario.")
        solicitarQtdDiasHospedagem()
    }
}

fun solicitarNomeHospede(): String {
    println("Qual o nome do hóspede? ")
    val nomeHospede = readln()
    return nomeHospede.ifBlank {
        println("Nome inválido. $nomeFuncionario.")
        solicitarNomeHospede()
    }
}

fun solicitarQuartoDisponivel(): Map<String, String> {

    println("Qual o quarto para reserva? (1 - 20)? ")

    return when (val quartoEscolhido = readln().toIntOrNull()) {
        in 1..20 -> {

            if (quartoEscolhido == null) return solicitarQuartoDisponivel()

            val quarto = QUARTOS[quartoEscolhido - 1]

            if (quarto.values.first() == "Livre") {

                println("Quarto Livre.")
                enter()
                quarto

            } else {

                println("${quarto.keys.first()} não está disponível. $nomeFuncionario.")
                enter()
                solicitarQuartoDisponivel()

            }
        }

        else -> {
            println("Número de quarto inválido. $nomeFuncionario.")
            enter()
            solicitarQuartoDisponivel()
        }
    }

}

fun confirmarHospedagem(
    nomeHospede: String,
    quartoReservado: Map<String, String>,
    valorDiaria: Double,
    qtdDiasHospedagem: Int
) {
    println(
        "$nomeFuncionario, você confirma a hospedagem para $nomeHospede por $qtdDiasHospedagem dias para o ${
            quartoReservado.keys.first().lowercase()
        } por R$${"%.2f".format(valorDiaria * qtdDiasHospedagem)}? S/N"
    )

    return when (readln().uppercase()) {
        "S" -> {
            val quartoIndex = QUARTOS.indexOf(quartoReservado)
            QUARTOS[quartoIndex] = mapOf(quartoReservado.keys.first() to "Ocupado")
            println("$nomeFuncionario, reserva efetuada para $nomeHospede.")
            enter()
            mostrarQuartos()
        }

        "N" -> {
            println("Hospedagem cancelada.")
            enter()
            mostrarQuartos()
        }

        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            enter()
            confirmarHospedagem(nomeHospede, quartoReservado, valorDiaria, qtdDiasHospedagem)
        }
    }
}

fun mostrarQuartos(){
    println("QUARTOS: \n")
    QUARTOS.forEach { quarto ->
        println("${quarto.keys.first()}: ${quarto.values.first()}")
    }
    enter()
    return inicio()
}