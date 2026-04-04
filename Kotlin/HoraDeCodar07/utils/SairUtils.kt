package HoraDeCodar07.utils

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.menus.nomeFuncionario
import kotlin.system.exitProcess

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
            pausarFluxo()
            return inicio()
        }

        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            return sairDoHotel()
        }
    }
}

fun voltarAoMenuPrincipal() {
    println("Retornando ao menu principal.")
    pausarFluxo()
    inicio()
}