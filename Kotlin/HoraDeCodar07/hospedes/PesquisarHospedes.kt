package HoraDeCodar07.hospedes

import HoraDeCodar07.menus.menuHospedes
import HoraDeCodar07.utils.pausarFluxo


fun pesquisarHospedeNomeExato() {
    println("PESQUISA DE HÓSPEDES\n")
    println("Digite o nome exato do hóspede para pesquisar ou \"VOLTAR\" para retornar ao menu de hóspedes: ")
    val nomePesquisa = readln()
    if (nomePesquisa.uppercase() == "VOLTAR") {
        println("Retornando ao menu de hóspedes.")
        pausarFluxo()
        return menuHospedes()
    }
    val hospedeEncontrado = HospedesRepositorio.pesquisarPorNomeExato(nomePesquisa)
    if (hospedeEncontrado != null) {
        println("[1] Hóspede encontrado: ${hospedeEncontrado.nome}, Quarto: ${hospedeEncontrado.quarto?.numero ?: "Não hospedado"}, Data/Hora do cadastro: ${hospedeEncontrado.dataCadastro}")

    } else {
        println("Hóspede não encontrado. Por favor, tente novamente.")
    }
    pausarFluxo()
    return pesquisarHospedeNomeExato()
}

fun pesquisarHospedesPrefixo() {
    println("PESQUISA DE HÓSPEDES\n")
    println("Digite o nome parcial ou completo do hóspede para pesquisar ou \"VOLTAR\" para retornar ao menu de hóspedes: ")
    val nomePesquisa = readln()
    if (nomePesquisa.uppercase() == "VOLTAR") {
        println("Retornando ao menu de hóspedes.")
        pausarFluxo()
        return menuHospedes()
    }
    val hospedeEncontrado = HospedesRepositorio.pesquisarPorPrefixo(nomePesquisa)
    if (hospedeEncontrado != null) {
        println("Resultados:")
        hospedeEncontrado.forEachIndexed { indice, hospede ->
            println("[${indice + 1}] Hóspede encontrado: ${hospede.nome}, Quarto: ${hospede.quarto?.numero ?: "Não hospedado"}, Data/Hora do cadastro: ${hospede.dataCadastro}")
        }
    } else {
        println("Nenhum hóspede encontrado. Por favor, tente novamente.")
    }
    pausarFluxo()
    return pesquisarHospedesPrefixo()
}