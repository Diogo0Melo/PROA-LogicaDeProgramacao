package HoraDeCodar07.hospedes

import HoraDeCodar07.menus.menuHospedes
import HoraDeCodar07.utils.pausarFluxo
import HoraDeCodar07.utils.solicitarNome

fun atualizarCadastroHospede() {
    println("ATUALIZAR CADASTRO DO HÓSPEDE\n")
    println("Digite o nome completo do hóspede: ")
    val nomeHospede = readln().ifBlank { return menuHospedes() }
    val hospedeEncontrado = HospedesRepositorio.pesquisarPorNomeExato(nomeHospede)
    if (hospedeEncontrado != null) {
        println("Hóspede ${hospedeEncontrado.nome} encontrado!")
        while (true) {
            println("O que deseja atualizar ?")
            println("1. Nome - 2. Sair")
            val opcao = readln().toIntOrNull()
            when (opcao) {

                1 -> atualizarNome(hospedeEncontrado)

                2 -> return menuHospedes()

                else -> println("Opção inválida")
            }
            pausarFluxo()
        }
    }
    println("Hóspede $nomeHospede não encontrado!")
    pausarFluxo()
    return menuHospedes()
}

fun atualizarNome(hospede: Hospede) {
    val resposta = HospedesRepositorio.atualizarNomeHospede(hospede, solicitarNome("do hóspede"))
    println("O nome do hóspede ${resposta.getValue("nomeAntigo")} foi alterado para ${hospede.nome}")
    return
}