package HoraDeCodar05

import kotlin.system.exitProcess

var saldo: Double = 100.5
var nome: String = ""
val senha: Int = 3589
var extrato = "Déposito de R$200.5\nSaque de R$50\nTransferência enviada de R$100\nTransferência recebida de R$50\n"
fun main() {
    if (nome.isEmpty()) perguntarNome()
    println("Olá, $nome é um prazer ter você aqui!")
    inicio()
}

fun perguntarNome() {
    println("Qual o seu nome?")
    nome = readln()
}

fun inicio() {
    println("1. Ver Saldo - 2. Ver Extrato - 3. Fazer Saque - 4. Fazer Déposito - 5. Fazer Transferência - 6. Sair")
    println("Escolha uma das opções acima: ")
    val escolha = readln().toIntOrNull()

    when (escolha) {
        1 -> verSaldo()
        2 -> verExtrato()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        5 -> fazerTransferencia()
        6 -> sair()
        else -> erro()
    }
}

fun validarSenha(): Boolean{
    println("Digite a senha: ")
    val senhaTemp = readln().toIntOrNull()

    if (senhaTemp != null && senhaTemp == senha) {
        println("Senha confirmada")
        return true

    } else {
        println("Senha incorreta")
        return false
    }

}

fun verSaldo() {
    if (!validarSenha()) {
        verSaldo()
        return
    }
    println("Seu saldo atual é: $saldo")
    inicio()
}

fun verExtrato() {
    if (!validarSenha()) {
        verExtrato()
        return
    }
    if (extrato.isEmpty()) println("Não há extratos disponíveis")
    else {
        println("Extrato: \n$extrato")
        inicio()
    }
}

fun fazerSaque() {
    if (!validarSenha()) {
        fazerSaque()
        return
    }
    print("Qual o valor para saque? ")
    val saque = readln().toDoubleOrNull()

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    } else if (saque > 0 && saque <= saldo) {
        saldo -= saque
        extrato += "Saque de R$$saque\n"
        verSaldo()
    } else {
        erroOperacao()
        fazerSaque()
    }
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    val deposito = readln().toDoubleOrNull()

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    } else if (deposito > 0.0) {
        saldo += deposito
        extrato += "Déposito de R$$deposito\n"
        verSaldo()
    } else {
        erroOperacao()
        fazerDeposito()
    }
}

fun fazerTransferencia() {
    if (!validarSenha()) {
        fazerTransferencia()
        return
    }
    println("Digite o número da conta: ")
    val numeroConta = readln().toIntOrNull()
    if (numeroConta != null) {
        println("Digite o valor que será tranferido: ")
        val valor = readln().toDoubleOrNull()
        if (valor != null && valor > 0 && valor <= saldo) {
            saldo -= valor
            extrato += "Transferência enviada de R$$valor\n"
            verSaldo()
        } else {
            erroOperacao()
            fazerTransferencia()
        }
    } else {
        erroOperacao()
        fazerTransferencia()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 e 6.")
    inicio()
}

fun erroOperacao() {
    println("Operação não autorizada")
}

fun sair() {
    println("Você deseja sair? (S/N) ")
    val confirma = readln().uppercase()

    when (confirma) {
        "S" -> {
            println("$nome, foi um prazer ter você por aqui!")
            exitProcess(0)
        }
        "N" -> inicio()
        else -> sair()
    }
}
