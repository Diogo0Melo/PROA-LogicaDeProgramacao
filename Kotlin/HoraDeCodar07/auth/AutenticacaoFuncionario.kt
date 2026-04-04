package HoraDeCodar07.auth

import HoraDeCodar07.utils.pausarFluxo
import HoraDeCodar07.utils.solicitarNome
import kotlin.system.exitProcess

fun loginFuncionario(): String {
    val tentativas = 3

    println("LOGIN DE FUNCIONÁRIO\n")

    val nomeFuncionario = solicitarNome("do funcionário")
    solicitarSenha(tentativas)

    println("Login efetuado com sucesso!")
    pausarFluxo()

    return nomeFuncionario
}

fun solicitarSenha(tentativas: Int): Int {
    var tentativas = tentativas
    if (tentativas == 0) {
        println("Excesso de tentativas, sistema bloqueado.")
        pausarFluxo()
        exitProcess(0)
    }
    println("Digite a senha: ")
    val senha = readln().toIntOrNull()
    if (senha != 2678) {
        println("Senha incorreta. Por favor, tente novamente.")
        println("Você tem ${--tentativas} tentativas restantes!")
        pausarFluxo()
        return solicitarSenha(tentativas)
    }
    return senha
}

