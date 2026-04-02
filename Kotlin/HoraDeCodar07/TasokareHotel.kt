package HoraDeCodar07

import kotlin.math.ceil
import kotlin.system.exitProcess

val NOME_REGEX = Regex("""^(?=.{3,})\p{L}+(?: \p{L}+)*$""")
val QUARTOS = Array(20) { index -> Quarto(index + 1, false, 0) }
val HOSPEDES_CADASTRADOS = mutableListOf<Hospede>()
val ESPACOS_EVENTOS = listOf(
    EspacoEvento("Auditório Laranja", 150, 70),
    EspacoEvento("Auditório Colorado", 350, 0),
)
val CUSTOS_BUFFET = mapOf(
    "Litro de café" to 0.80,
    "Litro de água" to 0.40,
    "Cento de salgado" to 34.0
)
val DIAS_UTEIS = listOf("Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira")
val FIM_DE_SEMANA = listOf("Sábado", "Domingo")
val POSTOS_DISPONIVEIS = listOf(
    Posto("Wayne Oil", 0.0, 0.0, ""),
    Posto("Stark Petrol", 0.0, 0.0, "")
)
val FORMATAR_PRECO: (Double) -> Double = { "%.2f".format(it).replace(",", ".").toDouble() }

class Quarto(
    val numero: Int,
    var ocupado: Boolean,
    var diasReservado: Int,
    var classe: String? = null,
    var hospedes: MutableList<Hospede>? = null
) {
    fun estaOcupado(): String {
        return if (ocupado) "Ocupado" else "Livre"
    }
}

class Hospede(val nome: String, val idade: Int, var quarto: Quarto?) {
    init {
        println("$nome cadastrado(a) com sucesso. ${tipoDeDesconto()}")
    }

    fun tipoDeDesconto(): String {
        return if (idade < 6) "$nome possui gratuidade" else if (idade > 60) "$nome paga meia" else ""
    }
}

data class EspacoEvento(
    val nomeLocal: String,
    val capacidade: Int,
    val capacidadeAdicional: Int,
    var listaReservas: MutableList<ReservaEvento>? = null
)

data class ReservaEvento(
    val reservante: String,
    val qtdPessoas: Int,
    val qtdGarcons: Int,
    val custoGarcom: Double,
    val qtdItensBuffet: IntArray,
    val custoBuffet: DoubleArray,
    val custoReserva: Double,
    val data: String,
    val horario: Int,
    val duracaoEvento: Int,
    val espacoEvento: EspacoEvento
)

data class Posto(val nome: String, var precoAlcool: Double, var precoGasolina: Double, var maisBarato: String)

var nomeFuncionario: String = ""

fun inicio() {
    if (nomeFuncionario == "") logar()
    println("Bem-vindo ao Tasokare Hotel, $nomeFuncionario. É um imenso prazer ter você por aqui!")
    println("1. Menu de Hóspedes - 2. Reservar Quarto - 3. Reservar Espaço para Eventos - 4. Abastecimento de Automóveis - 5. Manutenção de Ar Condicionados - 6. Relatórios Operacionais - 7. Sair do Hotel")
    println("Escolha uma opção:")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> menuHospedes()
        2 -> reservarQuarto()
        3 -> reservarEspacoEventos()
        4 -> abastecimentoDeAutomoveis()
        5 -> manutencaoArCondicionados()
        6 -> relatoriosOperacionais()
        7 -> sairDoHotel()
        else -> erroMenuPrincipal()
    }
}

fun logar() {
    println("LOGIN DE FUNCIONÁRIO\n")
    println("Digite o nome de usuário: ")
    val nomeUsuario = readln()
    if (nomeUsuario == "") return logar()
    var tentativas = 3
    while (true) {
        if (tentativas == 0) {
            println("Excesso de tentativas, sistema bloqueado.")
            exitProcess(0)
        }
        println("Digite a senha: ")
        val senha = readln().toIntOrNull()
        if (senha != 2678) {
            println("Senha incorreta. Por favor, tente novamente.")
            println("Você tem ${--tentativas} tentativas restantes!")
        } else break
    }
    nomeFuncionario = nomeUsuario
}

fun menuHospedes() {
    println("MENU DE HÓSPEDES\n")
    println("1. Cadastrar Hóspedes - 2. Pesquisar Hóspedes - 3. Listar Hóspedes Cadastrados - 4. Deletar Registro do Hóspede - 5. Voltar ao Menu Principal")
    println("Escolha uma opção:")
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> cadastrarHospedes()
        2 -> pesquisarHospedes()
        3 -> listarHospedesCadastrados()
        4 -> excluirHospede()
        5 -> voltarAoMenuPrincipal()
        else -> erroMenuHospedes()
    }
}

fun cadastrarHospedes() {
    val listaHospedesCadastrados = mutableListOf<Hospede>()
    while (true) {
        println("CADASTRO DE HÓSPEDES\n")
        println("Digite 'PARE' para finalizar o cadastro.")
        val nomeHospede = pedirNome()
        if (nomeHospede == "PARE") {
            println("Cadastro finalizado. Retornando ao menu principal.")
            if (listaHospedesCadastrados.isNotEmpty()) {
                var qtdGratuidades = 0
                var qtdMeiaEntrada = 0
                listaHospedesCadastrados.forEach {
                    HOSPEDES_CADASTRADOS.add(it)
                    if (it.idade < 6) qtdGratuidades++
                    else if (it.idade > 60) qtdMeiaEntrada++
                }
                println("Direito há $qtdGratuidades gratuidades e $qtdMeiaEntrada meia entradas para os hóspedes cadastrados.")
            }
            enter()
            return menuHospedes()
        } else {
            val idade = pedirIdade()
            listaHospedesCadastrados.add(Hospede(nome = nomeHospede, idade = idade, quarto = null))
        }
    }
}

fun pedirNome(): String {
    println("Digite o nome do hóspede: ")
    val nome = readln()
    if (NOME_REGEX.matches(nome)) {
        return nome
    } else {
        println("Nome inválido. Por favor, digite um nome válido.")
        return pedirNome()
    }
}

fun pedirIdade(): Int {
    println("Digite a idade do hóspede: ")
    val idade = readln().toIntOrNull()
    if (idade == null || idade <= 0) {
        println("Idade inválida. Por favor, digite um número positivo.")
        return pedirIdade()
    }
    return idade
}

fun pesquisarHospedes() {
    println("PESQUISA DE HÓSPEDES\n")
    println("Digite o nome do hóspede para pesquisar ou 'VOLTAR' para retornar ao menu de hóspedes: ")
    val nomePesquisa = readln()
    if (nomePesquisa.uppercase() == "VOLTAR") {
        println("Retornando ao menu de hóspedes.")
        enter()
        return menuHospedes()
    }
    val hospedeEncontrado = HOSPEDES_CADASTRADOS.find { it.nome.equals(nomePesquisa, ignoreCase = true) }
    if (hospedeEncontrado != null) {
        println("Hóspede encontrado: ${hospedeEncontrado.nome}, Idade: ${hospedeEncontrado.idade}, Quarto: ${hospedeEncontrado.quarto?.numero ?: "Não hospedado"}")
    } else {
        println("Hóspede não encontrado. Por favor, tente novamente.")
    }
    enter()
    return pesquisarHospedes()
}

fun listarHospedesCadastrados() {
    println("HÓSPEDES CADASTRADOS\n")
    if (HOSPEDES_CADASTRADOS.isEmpty()) {
        println("Nenhum hóspede cadastrado.")
    } else {
        HOSPEDES_CADASTRADOS.forEach { println("Nome: ${it.nome}, Idade: ${it.idade}, Quarto: ${it.quarto?.numero ?: "Não hospedado"}") }
    }
    enter()
    return menuHospedes()
}

fun excluirHospede() {
    println("DELETAR REGISTRO DO HÓSPEDE\n")
    println("Digite o nome do hóspede para deletar ou 'VOLTAR' para retornar ao menu de hóspedes: ")
    val nomeDeletar = readln()
    if (nomeDeletar.uppercase() == "VOLTAR") {
        println("Retornando ao menu de hóspedes.")
        enter()
        return menuHospedes()
    }
    val hospedeEncontrado = HOSPEDES_CADASTRADOS.find { it.nome.equals(nomeDeletar, ignoreCase = true) }
    if (hospedeEncontrado != null) {
        HOSPEDES_CADASTRADOS.remove(hospedeEncontrado)
        println("Hóspede ${hospedeEncontrado.nome} removido com sucesso.")
    } else {
        println("Hóspede não encontrado. Por favor, tente novamente.")
    }
    enter()
    return excluirHospede()
}

fun reservarQuarto() {
    println("RESERVA DE QUARTO\n")
    val valorDiaria = valorDiaria() ?: return inicio()
    val qtdDiarias = quantidadeDiarias() ?: return inicio()
    val classeQuarto = solicitarClasseDoQuarto() ?: return inicio()
    val subTotal = calcularSubTotal(valorDiaria, qtdDiarias, classeQuarto)
    val total = subTotal * (subTotal * 0.1) // 10% da taxa de serviço

    println("O valor de $qtdDiarias dias de hospedagem é: R$$subTotal")
    enter()

    val listaHospedes = selecionarHospedes().ifEmpty { return inicio() }
    val quartoSelecionado = selecionarQuarto()

    confirmarReserva(valorDiaria, qtdDiarias, listaHospedes, quartoSelecionado)

    mostrarQuartos()
    enter()
    return inicio()
}


fun valorDiaria(): Double? {
    println("Digite o valor da diária: ")
    val valor = readln().toDoubleOrNull()
    if (valor == null || valor <= 0) {
        println("Valor inválido. Por favor, digite um valor positivo.")
        return null
    }
    val valorFormatado = FORMATAR_PRECO(valor)
    return valorFormatado
}

fun quantidadeDiarias(): Int? {
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
        "standard" -> FORMATAR_PRECO(subTotal)
        "executive" -> FORMATAR_PRECO(subTotal * 1.35)
        "luxo" -> FORMATAR_PRECO(subTotal * 1.65)
        else -> throw IllegalArgumentException("NUNCA DEVERIA CHEGAR AQUI")
    }
}

fun selecionarHospedes(): MutableList<Hospede> {
    val listaHospedes = mutableListOf<Hospede>()
    while (true) {
        println("Digite o nome do hóspede para adicionar à reserva ou 'FIM' para finalizar a seleção: ")
        val nomeHospede = readln()
        if (nomeHospede.uppercase() == "FIM") {
            if (listaHospedes.isEmpty()) {
                println("Nenhum hóspede selecionado. Você retornará ao menu principal.")
                return listaHospedes
            }

            return listaHospedes
        } else if (listaHospedes.size == 15) {
            println("Limite máximo de 15 hóspedes por reserva/quarto atingido. Por favor encerre os registros.")
            enter()
            continue
        }
        val hospede = HOSPEDES_CADASTRADOS.find { it.nome.equals(nomeHospede, ignoreCase = true) }
        if (hospede != null) {
            listaHospedes.add(hospede)
            println("$nomeHospede adicionado à reserva.")
        } else {
            println("Hóspede não encontrado. Por favor, digite um nome válido ou cadastre o hóspede antes de selecioná-lo.")
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
    val quarto = QUARTOS[numeroQuarto - 1]
    if (quarto.ocupado) {
        println("O quarto $numeroQuarto já está ocupado. Por favor, selecione outro quarto.")
        mostrarQuartos()
        enter()
        return selecionarQuarto()
    }
    println("Quarto $numeroQuarto selecionado com sucesso!")
    return quarto
}

fun confirmarReserva(
    valorDiaria: Double,
    qtdDiarias: Int,
    hospedes: MutableList<Hospede>,
    quartoSelecionado: Quarto
) {
    println("$nomeFuncionario, você confirma a hospedagem para ${listarHospedesSelecionados(hospedes)} por $qtdDiarias dias para o quarto ${quartoSelecionado.numero} por R$${valorDiaria * qtdDiarias}? S/N")
    val opcao = readln().uppercase()
    when (opcao) {
        "S" -> {
            quartoSelecionado.ocupado = true
            quartoSelecionado.diasReservado = qtdDiarias
            quartoSelecionado.hospedes = hospedes
            hospedes.forEach { it.quarto = quartoSelecionado }
            println("Hospedagem confirmada para ${hospedes.size} hospede(s) no quarto ${quartoSelecionado.numero} por $qtdDiarias dias. Valor total: R$${valorDiaria * qtdDiarias}")
            return
        }

        "N" -> {
            println("Reserva cancelada. Retornando ao menu principal.")
            enter()
            return inicio()
        }

        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            return reservarQuarto()
        }
    }
}

fun listarHospedesSelecionados(hospedes: List<Hospede>): String {
    return hospedes.joinToString { it.nome }
}

private fun mostrarQuartos() {
    println("QUARTOS DO HOTEL\n")
    QUARTOS.forEach { quarto ->
        println("Quarto ${quarto.numero}: ${quarto.estaOcupado()} - Dias reservado: ${quarto.diasReservado} - Hóspedes: ${quarto.hospedes?.joinToString { it.nome } ?: "Nenhum"}")
    }
}

fun reservarEspacoEventos() {
    println("RESERVA DE ESPAÇO PARA EVENTOS\n")

    val qtdConvidados: Int = solicitarQuantidadePessoas() ?: return inicio()
    val localEvento: EspacoEvento? = selecionarEspacoEvento(qtdConvidados)

    enter()

    val diaReserva: String = solicitarDataReserva(localEvento) ?: return inicio()
    val horarioReserva: Int = solicitarHorarioReserva(diaReserva) ?: return inicio()
    val nomeReservante: String = solicitarNomeReservante() ?: return inicio()

    println("${localEvento?.nomeLocal} reservado para $nomeReservante no dia $diaReserva às ${horarioReserva}h para $qtdConvidados convidados.")
    enter()

    val duracaoEvento: Int = solicitarDuracaoEvento(diaReserva, horarioReserva) ?: return inicio()
    val qtdGarcons: Int = calcularQtdGarcons(qtdConvidados, duracaoEvento)
    val precoGarcons: Double = qtdGarcons * 10.50

    println("Serão necessários $qtdGarcons garçom(s). O custo total para os garçons é de R$$precoGarcons.")
    println("Agora vamos calcular o custo do buffet do hotel para o evento.")
    enter()

    val qtdCafe: Int = calcularQtdItems(qtdConvidados, 0.2)
    val qtdAgua: Int = calcularQtdItems(qtdConvidados, 0.5)
    val qtdSalgados: Int = calcularQtdItems(qtdConvidados, 7.0)

    val precoTotalCafe = calcularPrecoItemBuffet(qtdCafe, "Litro de café")
    val precoTotalAgua = calcularPrecoItemBuffet(qtdAgua, "Litro de água")
    val precoTotalSalgados = calcularPrecoItemBuffet(qtdSalgados / 100, "Cento de salgado")

    val precoBuffet = calcularCustoBuffet(precoTotalCafe, precoTotalAgua, precoTotalSalgados)

    println("O evento precisará de $qtdCafe litros de café, $qtdAgua litros de água, $qtdSalgados salgados.")

    enter()

    println("Evento no ${localEvento?.nomeLocal}.")
    println("Nome do reservante: $nomeReservante.")
    println("Data: $diaReserva, Horário: ${horarioReserva}h às ${horarioReserva + duracaoEvento}h.")
    println("Duração do evento: $duracaoEvento horas.")
    println("Quantidade de garçons necessários: $qtdGarcons.")
    println("Quantidade de convidados: $qtdConvidados.")
    println("\nCusto dos garçons: R$$precoGarcons.")
    println("Custo do buffet: R$$precoBuffet.")
    println("\nValor total do evento: R$${precoGarcons + precoBuffet}.")

    println("\nGostaria de efetuar a reserva para este evento? S/N")

    while (true) {
        val confirmarReserva = readln().uppercase()
        when (confirmarReserva) {
            "S" -> {
                val reserva = ReservaEvento(
                    reservante = nomeReservante,
                    qtdPessoas = qtdConvidados,
                    qtdGarcons = qtdGarcons,
                    custoGarcom = precoGarcons,
                    qtdItensBuffet = intArrayOf(qtdCafe, qtdAgua, qtdSalgados),
                    custoBuffet = doubleArrayOf(precoTotalCafe, precoTotalAgua, precoTotalSalgados),
                    custoReserva = precoGarcons + precoBuffet,
                    data = diaReserva,
                    horario = horarioReserva,
                    duracaoEvento = duracaoEvento,
                    espacoEvento = localEvento!!
                )
                localEvento.listaReservas?.add(reserva) ?: run { localEvento.listaReservas = mutableListOf(reserva) }
                println("$nomeFuncionario, reserva efetuada com sucesso.")
                enter()
                return inicio()
            }

            "N" -> {
                println("Reserva não efetuada. Retornando ao menu principal.")
                enter()
                return inicio()
            }

            else -> {
                println("Opção inválida. Por favor, responda com S ou N.")
            }
        }
    }
}

fun solicitarQuantidadePessoas(): Int? {

    println("Digite a quantidade de convidados para o evento: ")

    val qtdConvidados = readln().toIntOrNull()

    if (qtdConvidados !in 1..350) {
        println("Número de convidados inválido. Por favor, digite um número positivo e que não vá além de 350.")
        return solicitarQuantidadePessoas()
    }
    return qtdConvidados
}

fun selecionarEspacoEvento(qtdConvidados: Int): EspacoEvento? {
    return when (qtdConvidados) {
        in 1..220 -> {
            println("O espaço 'Auditório Laranja' será utilizado para o evento. ${if (qtdConvidados > 150) "Será necessário adicionar ${qtdConvidados - 150} cadeiras." else ""}")
            ESPACOS_EVENTOS[0]
        }

        in 221..350 -> {
            println("O espaço 'Auditório Colorado' será utilizado para o evento.")
            ESPACOS_EVENTOS[1]
        }
        // O caso menor que 0 ou maior que 350 convidados já é tratado na função solicitarQuantidadePessoas(), mas o else é mantido para garantir que a função retorne um valor nulo caso haja algum erro inesperado. E também é obrigatório else para o when, já que ele é uma expressão e deve retornar um valor em todos os casos.
        else -> {
            println("Número de convidados excede a capacidade máxima dos espaços disponíveis. Por favor, reduza o número de convidados ou escolha outro espaço.")
            null
        }
    }
}

fun solicitarDataReserva(localEvento: EspacoEvento?): String? {
    println("Segunda, Terça, Quarta, Quinta, Sexta, Sábado ou Domingo?")
    println("Digite o dia da semana para reservar ou 'VOLTAR' para retornar ao menu principal: ")
    val data = readln().uppercase()
    if (data == "VOLTAR") return null
    val disponivel: Boolean
    return when (data) {
        "SEGUNDA" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Segunda-feira", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Segunda-feira. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Segunda-feira"
        }

        "TERÇA" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Terça-feira", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Terça-feira. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Terça-feira"
        }

        "QUARTA" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Quarta-feira", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Quarta-feira. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Quarta-feira"
        }

        "QUINTA" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Quinta-feira", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Quinta-feira. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Quinta-feira"
        }

        "SEXTA" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Sexta-feira", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Sexta-feira. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Sexta-feira"
        }

        "SÁBADO" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Sábado", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Sábado. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Sábado"
        }

        "DOMINGO" -> {
            disponivel = verificarDisponibilidadeEspacoEvento("Domingo", localEvento)
            if (!disponivel) {
                println("O espaço para eventos já está reservado para Domingo. Por favor, escolha outro dia.")
                return solicitarDataReserva(localEvento)
            }
            "Domingo"
        }

        else -> {
            println("Dia da semana inválido. Por favor, digite um dia válido.")
            solicitarDataReserva(localEvento)
        }
    }
}

fun verificarDisponibilidadeEspacoEvento(dia: String, localEvento: EspacoEvento?): Boolean {
    if (localEvento == null) return false
    val reservas = localEvento.listaReservas ?: return true
    return reservas.none { it.data.equals(dia, ignoreCase = true) }
}

fun solicitarHorarioReserva(diaReserva: String): Int? {
    println("Digite o horário para reservar: ")
    val horario = readln().toIntOrNull()
    if (diaReserva in DIAS_UTEIS) {
        if (horario !in 7..23) {
            println("Horário inválido para dias úteis. Por favor, escolha um horário entre 7h e 23h.")
            return solicitarHorarioReserva(diaReserva)
        }
    } else if (diaReserva in FIM_DE_SEMANA) {
        if (horario !in 7..15) {
            println("Horário inválido para fim de semana. Por favor, escolha um horário entre 7h e 15h.")
            return solicitarHorarioReserva(diaReserva)
        }
    }
    return horario
}

fun solicitarNomeReservante(): String? {
    println("Digite o nome do reservante ou 'VOLTAR' para retornar ao menu principal: ")
    val nomeReservante = readln()
    if (nomeReservante.uppercase() == "VOLTAR") return null
    if (NOME_REGEX.matches(nomeReservante)) {
        return nomeReservante
    } else {
        println("Nome inválido. Por favor, digite um nome válido.")
        return solicitarNomeReservante()
    }
}

private fun solicitarDuracaoEvento(diaReserva: String, horarioReserva: Int): Int? {
    println("Digite a duração do evento em horas: ")
    val duracao = readln().toIntOrNull() ?: 0
    if (duracao <= 0) {
        println("Duração inválida. Por favor, digite um número positivo.")
        return solicitarDuracaoEvento(diaReserva, horarioReserva)
    } else if (diaReserva in DIAS_UTEIS) {
        if (horarioReserva + duracao > 23) {
            println("A duração do evento excede o horário permitido para dias úteis. Por favor, escolha uma duração que termine até as 23h.")
            return solicitarDuracaoEvento(diaReserva, horarioReserva)
        }
    } else if (diaReserva in FIM_DE_SEMANA) {
        if (horarioReserva + duracao > 15) {
            println("A duração do evento excede o horário permitido para fim de semana. Por favor, escolha uma duração que termine até as 15h.")
            return solicitarDuracaoEvento(diaReserva, horarioReserva)
        }
    }
    return duracao
}

fun calcularQtdGarcons(qtdConvidados: Int, duracaoEvento: Int): Int {
    var qtdGarcons = ceil(qtdConvidados / 12.0).toInt()
    // A cada 2 horas de evento, é necessário contratar mais um garçom para garantir um bom atendimento aos convidados.
    for (i in 1..duracaoEvento) if (i % 2 == 0) qtdGarcons++

    return qtdGarcons
}

fun calcularQtdItems(qtdConvidados: Int, consumoPorPessoa: Double): Int {
    return ceil(qtdConvidados * consumoPorPessoa).toInt()
}

fun calcularPrecoItemBuffet(qtdItem: Int, nomeItem: String): Double {
    val precoUnitario: Double = CUSTOS_BUFFET[nomeItem]!!
    val precoTotal: Double = qtdItem * precoUnitario
    return precoTotal

}

fun calcularCustoBuffet(precoCafe: Double, precoAgua: Double, precoSalgados: Double): Double {
    val precoTotalBuffet: Double = precoCafe + precoAgua + precoSalgados
    return precoTotalBuffet
}

fun abastecimentoDeAutomoveis() {

    println("ABASTECIMENTO DE AUTOMÓVEIS\n")

    POSTOS_DISPONIVEIS.forEach { posto ->
        lerPrecoAlcool(posto)
        lerPrecoGasolina(posto)
    }
    val postoAlcoolBarato = POSTOS_DISPONIVEIS.minBy { it.precoAlcool }
    val postoGasolinaBarata = POSTOS_DISPONIVEIS.minBy { it.precoGasolina }

    val melhorPosto = calcularMelhorPrecoCombustivel(postoAlcoolBarato, postoGasolinaBarata)

    when (melhorPosto.maisBarato) {
        "álcool" -> println("$nomeFuncionario, é mais barato abastecer com álcool no posto ${melhorPosto.nome}")
        "gasolina" -> println("$nomeFuncionario, é mais barato abastecer com gasolina no posto ${melhorPosto.nome}")
    }

    enter()
    return inicio()
}

fun lerPrecoAlcool(posto: Posto) {
    println("Qual o valor do álcool no posto ${posto.nome}?")
    posto.precoAlcool = readln().toDoubleOrNull() ?: 0.0
    if (posto.precoAlcool <= 0.0) {
        println("Valor inválido. Por favor, informe um número válido para o preço do álcool.")
        return lerPrecoAlcool(posto)
    }
}

fun lerPrecoGasolina(posto: Posto) {
    println("Qual o valor da gasolina no posto ${posto.nome}?")
    posto.precoGasolina = readln().toDoubleOrNull() ?: 0.0
    if (posto.precoAlcool <= 0.0) {
        println("Valor inválido. Por favor, informe um número válido para o preço da gasolina.")
        return lerPrecoGasolina(posto)
    }
}

fun calcularMelhorPrecoCombustivel(postoAlcoolBarato: Posto, postoGasolinaBarata: Posto): Posto {
    return when {
        postoAlcoolBarato.precoAlcool / postoGasolinaBarata.precoGasolina < 0.7 -> {
            postoAlcoolBarato.maisBarato = "álcool"
            postoAlcoolBarato
        }

        else -> {
            postoGasolinaBarata.maisBarato = "gasolina"
            postoGasolinaBarata
        }
    }
}

fun manutencaoArCondicionados() {
    val empresasContatadas =
        mutableMapOf<String, Double>() // O nome da empresa é a chave e o valor do orçamento é o valor do mapa.



    while (true) {
        println("MANUTENÇÃO DE AR CONDICIONADOS\n")

        println("Digite 'VOLTAR' para retornar ao menu principal. AVISO: os dados informados até o momento não serão salvos ou processados.")

        println("Qual o nome da empresa?")
        val nomeEmpresa = readln()

        if (nomeEmpresa.uppercase() == "VOLTAR") {
            println("Retornando ao menu principal.")
            enter()
            return inicio()
        }

        println("Qual o valor por aparelho?")
        val valorAparelho = readln().toDoubleOrNull()

        println("Qual a quantidade de aparelhos?")
        val qtdAparelhos = readln().toIntOrNull()

        println("Qual a porcentagem de desconto?")
        val porcentagemDesconto = readln().toDoubleOrNull()

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val qtdMinimaDesconto = readln().toIntOrNull()

        if (nomeEmpresa.isEmpty() || valorAparelho == null || valorAparelho <= 0 || qtdAparelhos == null || qtdAparelhos <= 0 || porcentagemDesconto == null || porcentagemDesconto < 0 || porcentagemDesconto > 100 || qtdMinimaDesconto == null || qtdMinimaDesconto <= 0) {
            println("Dados inválidos. Por favor, informe os dados corretamente.")
            continue
        }

        val valorTotal: Double = valorAparelho * qtdAparelhos
        val valorComDesconto: Double =
            if (qtdMinimaDesconto in 2..qtdAparelhos) valorTotal - valorTotal * (porcentagemDesconto / 100) else valorTotal

        println("O serviço da empresa $nomeEmpresa custará um total de R$${"%.2f".format(valorComDesconto)}.")

        empresasContatadas[nomeEmpresa] = valorComDesconto

        var resposta: String

        while (true) {
            println("Deseja adicionar outra empresa? S/N")
            resposta = readln().uppercase()
            when (resposta) {
                "S" -> break
                "N" -> break
                else -> println("Opção inválida. Por favor, responda com S ou N.")
            }
        }
        if (resposta == "N") break
    }

    val melhorEmpresa = empresasContatadas.minBy { it.value }
    println("A melhor opção é a empresa ${melhorEmpresa.key} com um custo total de R$${"%.2f".format(melhorEmpresa.value)}.")

    enter()
    return inicio()
}

fun relatoriosOperacionais() {}

fun erroMenuPrincipal() {
    println("Por favor, informe um número entre 1 e 6.")
    return inicio()
}

fun erroMenuHospedes() {
    println("Por favor, informe um número entre 1 e 5.")
    return menuHospedes()
}

fun voltarAoMenuPrincipal() {
    println("Retornando ao menu principal.")
    enter()
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair? S/N")
    val confirma = readln().uppercase()
    when (confirma) {
        "S" -> {
            println("Muito obrigado e até logo, $nomeFuncionario!")
            exitProcess(0)
        }

        "N" -> {
            println("Retornando ao menu principal.")
            enter()
            return inicio()
        }

        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            return sairDoHotel()
        }
    }
}

fun enter() {
    println("Pressione Enter para continuar...")
    readln()
}

fun main() {
    // Função principal que chama a função inicio().
    inicio()
}


