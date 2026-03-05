import kotlin.system.exitProcess

// Regex: apenas letras Unicode (inclui acentos) e exatamente um espaço entre cada parte do nome, mínimo 3 letras
private val NOME_REGEX = Regex("""^(?=.{3,})\p{L}+(?: \p{L}+)*$""")
private val SENHA_REGEX = Regex("""^\d{4}$""")

var contasBancarias: MutableList<ContaBancaria> = mutableListOf()
var contasCriadas: Int = 0
var contaAtual: ContaBancaria? = null

fun main() {
    telaPrincipal()
}

fun telaPrincipal() {
    while (true) {
        println("\nBem-vindo ao Banco Tchan!")
        println("1. Criar conta")
        println("2. Acessar conta")
        println("0. Encerrar")
        val opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> criarConta()
            2 -> acessarConta()
            0 -> encerrar()
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun criarConta() {
    println("CRIAÇÃO DE CONTA\n")

    val nome = pedirNome()
    val senha = criarSenha()
    val numeroConta = gerarNumeroConta()

    val conta = ContaBancaria(nome, numeroConta, senha)
    contasBancarias.add(conta)

    println("Conta criada com sucesso! Para acessar utilize o número da conta: $numeroConta")
    enter()
}

fun pedirNome(): String {
    while (true) {
        println("Pressione Enter para retornar ao menu principal a qualquer momento.")
        print("Digite seu nome: ")
        val nome = readln().trim()
        retornarMenuPrincipal(nome)

        if (!NOME_REGEX.matches(nome)) {
            println("Nome inválido. Use apenas letras (incluindo acentos) e um único espaço entre as partes do nome. Ex: Davilson Metronomo")
            continue
        }

        return nome
    }
}

fun criarSenha(): String {
    while (true) {
        println("Pressione Enter para retornar ao menu principal a qualquer momento.")
        print("Escolha uma senha numérica de 4 dígitos: ")
        val senha = readln().trim()
        retornarMenuPrincipal(senha)
        if (senha.matches(SENHA_REGEX)) {
            if (confirmarSenha(senha)) {
                return senha
            } else {
                println("As senhas não coincidem. Tente novamente.")
            }
        } else println("Senha inválida. Deve conter exatamente 4 dígitos.")
    }
}

fun confirmarSenha(senha: String): Boolean {
    while (true) {
        println("Pressione Enter para retornar ao menu principal a qualquer momento.")
        print("Confirme sua senha: ")
        val confirmacao = readln().trim()
        retornarMenuPrincipal(confirmacao)
        return senha == confirmacao
    }
}

fun gerarNumeroConta(): String {
    contasCriadas++
    val numeroConta: String = contasCriadas.toString().padStart(4, '0')
    return numeroConta
}

fun acessarConta() {
    do {
        println("ACESSAR CONTA\n")

        println("Pressione Enter para retornar ao menu principal a qualquer momento.")
        println("Digite o número da conta: ")
        val numeroConta = readln().trim()
        val conta = contasBancarias.find { it.numeroConta == numeroConta } ?: if (numeroConta == "") "" else null
        retornarMenuPrincipal(if (conta == "Não Encontrada") "" else numeroConta)
        if (conta == null) println("Conta não encontrada. Tente novamente.")
        else contaAtual = conta as ContaBancaria?
    } while (conta == null)

    while (true) {
        println("Pressione Enter para retornar ao menu principal a qualquer momento.")
        println("Digite a senha: ")
        val senha = readln().trim()
        retornarMenuPrincipal(senha)
        if (senha == contaAtual?.senha) {
            menuConta()
            return
        } else {
            println("Senha incorreta. Tente novamente.")
        }
    }

}

fun menuConta() {

    while (true) {
        if (contaAtual == null) return

        println("Olá, ${contaAtual?.nome} é um prazer ter você aqui!")
        println("1. Ver saldo")
        println("2. Ver extrato")
        println("3. Fazer depósito")
        println("4. Fazer saque")
        println("5. Transferir dinheiro")
        println("6. Trabalhar (ganhar dinheiro)")
        println("7. Jogar no Tigrinho (perder dinheiro)")
        println("0. Sair da conta")
        val opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerDeposito()
            4 -> fazerSaque()
            5 -> transferir()
            6 -> trabalhar()
            7 -> jogarTigrinho()
            0 -> {
                println("${contaAtual?.nome}, foi um prazer ter você por aqui!")
                enter()
                contaAtual = null
                return
            }

            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun verSaldo() {
    println("SALDO\n")
    println("Seu saldo atual em conta é: R$ ${contaAtual?.saldoEmConta}")
    println("Seu saldo atual em mãos é: R$ ${contaAtual?.saldoEmMaos}")
    enter()
}

fun verExtrato() {
    println("EXTRATO\n")
    if (contaAtual?.extrato.isNullOrEmpty()) {
        println("Não há extratos disponíveis.")
    } else {
        println("Extrato:")
        contaAtual?.extrato?.forEach { println(it) }
    }
    enter()
}

fun fazerDeposito() {
    println("DEPÓSITO\n")
    print("Digite o valor a ser depositado: R$ ")
    val valor = readln().toDoubleOrNull()
    if (valor != null && valor > 0) {
        if (valor > (contaAtual?.saldoEmMaos ?: 0.0)) {
            println("Saldo em mãos insuficiente para depósito. Tente novamente.")
            enter()
        } else {
            contaAtual?.depositar(valor)
            println("Depósito de R$ $valor realizado com sucesso!")
            enter()
        }
    } else {
        println("Valor inválido. Tente novamente.")
        enter()
    }
}

fun fazerSaque() {
    println("SAQUE\n")
    print("Digite o valor a ser sacado: R$ ")
    val valor = readln().toDoubleOrNull()
    if (valor != null && valor > 0) {
        if (valor > (contaAtual?.saldoEmConta ?: 0.0)) {
            println("Saldo em conta insuficiente para saque. Tente novamente.")
            enter()
        } else {
            contaAtual?.sacar(valor)
            println("Saque de R$ $valor realizado com sucesso!")
            enter()
        }
    } else {
        println("Valor inválido. Tente novamente.")
        enter()
    }
}

fun transferir() {
    println("TRANSFERÊNCIA\n")
    print("Digite o número da conta de destino: ")
    val numeroContaDestino = readln().trim()
    val contaDestino = contasBancarias.find { it.numeroConta == numeroContaDestino }

    if (contaDestino == null) {
        println("Conta de destino não encontrada. Tente novamente.")
        enter()
        return
    }
    else if(contaDestino.numeroConta == contaAtual?.numeroConta) {
        println("🤦 OPA! ESPERA AÍ! 🤦")
        println("Transferir para a MESMA conta? É sério isso?")
        println("Você não é um é um debugador seniôr... é apenas o usuario usando o sistema de forma errada! 😤")
        println("Use o sistema corretamente, oh 'debugador senior!' Não desperdice recursos do banco Tchan com essas gambiarras!")
        enter()
        return
    }
    print("Digite o valor a ser transferido: R$ ")
    val valor = readln().toDoubleOrNull()
    if (valor != null && valor > 0) {
        if (valor > (contaAtual?.saldoEmConta ?: 0.0)) {
            println("Saldo em conta insuficiente para transferência. Tente novamente.")
            enter()
        } else {
            contaAtual?.transferir(contaDestino, valor)
            println("Transferência de R$ $valor para ${contaDestino.nome} realizada com sucesso!")
            enter()
        }
    } else {
        println("Valor inválido. Tente novamente.")
        enter()
    }
}

fun trabalhar() {
    println("TRABALHAR\n")
    val salario = (57..909).random().toDouble()
    print("TRABALHANDO!!!")
    for (i in 1..8) {
        print(".")
        Thread.sleep(1000)
    }

    contaAtual?.trabalhar(salario)
    println("\nParabéns, você ganhou R$ $salario trabalhando!")
    enter()
    pagarBoleto()
}

fun pagarBoleto() {
    val contas = listOf(
        "Gás" to (40..120).random().toDouble(),
        "Luz" to (50..200).random().toDouble(),
        "Água" to (30..150).random().toDouble(),
        "Combustível" to (100..400).random().toDouble(),
        "Refeição" to (20..100).random().toDouble(),
        "Internet" to (80..300).random().toDouble(),
        "Aluguel" to (500..1500).random().toDouble(),
        "Supermercado" to (200..800).random().toDouble(),
        "Transporte" to (100..400).random().toDouble(),
        "Lazer" to (100..500).random().toDouble(),
        "Outros" to (50..300).random().toDouble()
    )
    val contaParaPagar = contas.random()

    println("Hora de pagar alguma boleto! Seu boleto de ${contaParaPagar.first} é de R$ ${contaParaPagar.second}")
    print("Pagando")
    for (i in 1..10) {
        print(".")
        Thread.sleep(500)
    }
    if ((contaAtual?.saldoEmConta ?: 0.0) >= (contaParaPagar.second - 1000)) {
        contaAtual?.pagarBoleto(contaParaPagar.second, contaParaPagar.first)
        println("\nBoleto de ${contaParaPagar.first} paga com sucesso! Agora volte a trabalhar para ganhar mais dinheiro!")
        enter()
    } else {
        println("\n⚠️ ALERTA CRÍTICO! ⚠️")
        println("Saldo insuficiente! Sua conta não tem R$ ${contaParaPagar.second} disponível.")
        println("Seu saldo: R$ ${contaAtual?.saldoEmConta ?: 0.0} | Limite de crédito: R$ 1000,00")
        println("Total disponível: R$ ${(contaAtual?.saldoEmConta ?: 0.0) + 1000.0} (insuficiente! 😭)")
        println("\n🚨 SUA CONTA FOI FINALIZADA POR INADIMPLÊNCIA! 🚨")
        println("O banco Tchan não tolera caloteiros! Você foi bloqueado do sistema.")
        println("Volte quando tiver mais responsabilidade financeira! 💸")
        deletarContaInadimplente()
    }

}

fun deletarContaInadimplente() {
    contasBancarias.remove(contaAtual)
    contaAtual = null
    enter()
}

fun jogarTigrinho() {
    println("JOGAR NO TIGRINHO\n")

    println("Bem-vindo ao Tigrinho! O jogo mais emocionante do Banco Tchan! 🐯")
    println("Aposte um valor em conta e tente a sorte! Se ganhar, seu saldo apostado é multiplicado em 1_000_000x! Se perder, seu saldo apostado agora é do banco Tchan! 😱")
    print("Digite o valor a ser apostado: R$ ")
    val valor = readln().toDoubleOrNull()
    if (valor != null && valor > 0) {
        if (valor > (contaAtual?.saldoEmConta ?: 0.0)) {
            println("Saldo em conta insuficiente para apostar. Tente novamente.")
            enter()
        } else {
            println("Escolha um número entre 0 e 1.000.000. Se o número sorteado for igual ao seu, você ganha! Se não, perde!")
            print("Escolha seu número da sorte: ")
            val numeroEscolhido = readln().toIntOrNull()
            val resultado = (0..1_000_000).random()
            print("JOGANDO!!!")
            for (i in 1..10) {
                print(".")
                Thread.sleep(500)

            }



            if (numeroEscolhido != null && numeroEscolhido == resultado) {
                contaAtual?.depositar(valor * 1_000_000)
                println("PARABÉNS, VOCÊ GANHOU NO TIGRINHO! 🐯🎉")
                println("Número sorteado: $resultado | Seu número: $numeroEscolhido")
                println("Valor ganho: R$ ${valor * 1_000_000}")
            } else {
                contaAtual?.sacar(valor)
                println("QUE PENA, VOCÊ PERDEU NO TIGRINHO! 😢")
                println("Número sorteado: $resultado | Seu número: $numeroEscolhido")
                println("Valor perdido: R$ $valor")

            }
            enter()
        }
    } else {
        println("Valor inválido. Tente novamente.")
        enter()
    }
}

fun encerrar() {
    print("Encerrando o programa")
    for (i in 1..3) {
        print(".")
        Thread.sleep(750)
    }
    exitProcess(0)
}

fun retornarMenuPrincipal(dado: String) {
    if (dado.isEmpty()) {
        print("Retornando ao menu principal")
        for (i in 1..3) {
            print(".")
            Thread.sleep(750)
        }
        telaPrincipal()
    }
}

fun enter() {
    println("Pressione Enter para continuar...")
    readln()
}

data class ContaBancaria(
    val nome: String,
    val numeroConta: String,
    val senha: String,
    var saldoEmConta: Double = 0.0,
    var saldoEmMaos: Double = 0.0,
    var extrato: MutableList<String> = mutableListOf()
) {

    fun depositar(valor: Double) {
        saldoEmConta += valor
        saldoEmMaos -= valor
        extrato.add("Depósito: R$ $valor")
    }

    fun sacar(valor: Double) {
        saldoEmConta -= valor
        saldoEmMaos += valor
        extrato.add("Saque: R$ $valor")
    }

    fun transferir(destino: ContaBancaria, valor: Double) {
        saldoEmConta -= valor
        destino.saldoEmConta += valor
        extrato.add("Transferência enviada: R$ $valor para ${destino.nome}")
        destino.extrato.add("Transferência recebida: R$ $valor de ${this.nome}")
    }

    fun trabalhar(valor: Double) {
        saldoEmMaos += valor
    }

    fun pagarBoleto(valor: Double, descricao: String) {
        saldoEmConta -= valor
        extrato.add("Pagamento de boleto: R$ $valor - $descricao")

    }

}