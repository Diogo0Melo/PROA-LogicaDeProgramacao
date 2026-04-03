package HoraDeCodar07.hospedes

import HoraDeCodar07.menus.menuHospedes
import HoraDeCodar07.utils.pausarFluxo

fun excluirHospede() {
    println("DELETAR REGISTRO DO HÓSPEDE\n")
    println("Digite o nome completo do hóspede para deletar ou 'VOLTAR' para retornar ao menu de hóspedes: ")
    val nomeDeletar = readln()
    if (nomeDeletar.uppercase() == "VOLTAR") {
        println("Retornando ao menu de hóspedes.")
        pausarFluxo()
        return menuHospedes()
    }
    val hospedeEncontrado = HospedesRepositorio.pesquisarPorNomeExato(nomeDeletar)
    if (hospedeEncontrado != null) {
        val resposta = HospedesRepositorio.deletarHospede(hospedeEncontrado)
        if(resposta) println("Hóspede ${hospedeEncontrado.nome} removido com sucesso.")
        else println("Erro ao remover hóspede. Tente novamente.")
    } else {
        println("Hóspede não encontrado. Por favor, tente novamente.")
    }
    pausarFluxo()
    return excluirHospede()
}