package Hotel

import kotlin.system.exitProcess

val NOME_REGEX = Regex("""^(?=.{3,})\p{L}+(?: \p{L}+)*$""")
val QUARTOS = Array(20) { index -> Quarto(index + 1, false, 0) }
val HOSPEDES_CADASTRADOS = mutableListOf<Hospede>()

class Quarto(
    val numero: Int,
    var ocupado: Boolean,
    var diasReservado: Int,
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

var nomeFuncionario: String = ""

fun main() {
    // Função principal que chama a função inicio().
    inicio()
}

fun inicio() {
    if (nomeFuncionario == "") logar()
    println("Bem-vindo ao Hotel {Hotel}, $nomeFuncionario. É um imenso prazer ter você por aqui!")
    println("1. Cadastrar Hóspedes - 2. Reservar Quarto - 3. Abastecimento de Automóveis - 4. Sair do Hotel")
    println("Escolha uma opção:")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> cadastrarHospedes()
        2 -> reservarQuarto()
        3 -> AbastecimentoDeAutomoveis()
        4 -> sairDoHotel()
        else -> erro()
    }
}

fun logar() {
    println("LOGIN DE FUNCIONÁRIO\n")
    println("Digite o nome de usuário: ")
    val nomeUsuario = readln()
    if (nomeUsuario == "") return logar()
    println("Digite a senha: ")
    val senha = readln().toIntOrNull()
    if (senha != 2678) {
        println("Senha incorreta. Por favor, tente novamente.")
        return logar()
    }
    nomeFuncionario = nomeUsuario
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
                println("Direito há $qtdGratuidades gratuidades e $qtdMeiaEntrada meias entradas para os hóspedes cadastrados.")
            }
            enter()
            return inicio()
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

fun reservarQuarto() {
    println("RESERVA DE QUARTO\n")
    val valorDiaria = valorDiaria() ?: return inicio()
    val qtdDiarias = quantidadeDiarias() ?: return inicio()

    println("O valor de $qtdDiarias dias de hospedagem é: R$${valorDiaria * qtdDiarias}")
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
    return valor
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

fun mostrarQuartos() {
    println("QUARTOS DO HOTEL\n")
    QUARTOS.forEach { quarto ->
        println("Quarto ${quarto.numero}: ${quarto.estaOcupado()} - Dias reservado: ${quarto.diasReservado} - Hóspedes: ${quarto.hospedes?.joinToString { it.nome } ?: "Nenhum"}")
    }
}


fun AbastecimentoDeAutomoveis() {

}


fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    return inicio()
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


