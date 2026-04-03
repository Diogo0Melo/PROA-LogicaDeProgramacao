package HoraDeCodar07.menus

import HoraDeCodar07.hospedes.*
import HoraDeCodar07.utils.erroMenuHospedes
import HoraDeCodar07.utils.voltarAoMenuPrincipal

fun menuHospedes() {
    println("MENU DE HÓSPEDES\n")
    println("1. Cadastrar Hóspedes - 2. Pesquisar Hóspede Nome Exato - 3. Pesquisar Hóspedes por Prefixo - 4. Listar Hóspedes Cadastrados - ")
    println("5. Atualizar Cadastro do Hóspede - 6. Deletar Registro do Hóspede - 7. Voltar ao Menu Principal")
    println("Escolha uma opção:")
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> cadastrarHospedes()
        2 -> pesquisarHospedeNomeExato()
        3 -> pesquisarHospedesPrefixo()
        4 -> listarHospedes()
        5 -> atualizarCadastroHospede()
        6 -> excluirHospede()
        7 -> voltarAoMenuPrincipal()
        else -> erroMenuHospedes()
    }
}