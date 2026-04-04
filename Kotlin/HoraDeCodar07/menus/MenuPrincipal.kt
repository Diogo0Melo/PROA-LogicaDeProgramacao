package HoraDeCodar07.menus

import HoraDeCodar07.abastecimento.abastecimentoDeAutomoveis
import HoraDeCodar07.ar_condicionado.manutencaoArCondicionados
import HoraDeCodar07.auth.loginFuncionario
import HoraDeCodar07.eventos.reservarEspacoEvento
import HoraDeCodar07.reservas.reservarQuarto
import HoraDeCodar07.utils.erroMenuPrincipal

const val NOME_HOTEL = "Tasokare Hotel"
val nomeFuncionario: String = loginFuncionario()

fun inicio() {
    println("Bem-vindo ao $NOME_HOTEL, $nomeFuncionario. É um imenso prazer ter você por aqui!")
    println("1. Menu de Hóspedes - 2. Reservar Quarto - 3. Reservar Espaço para Eventos - 4. Abastecimento de Automóveis")
    println("5. Manutenção de Ar-Condicionados - 6. Relatórios Operacionais - 7. Sair do Hotel")
    println("Escolha uma opção:")
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> menuHospedes()
        2 -> reservarQuarto()
        3 -> reservarEspacoEvento()
        4 -> abastecimentoDeAutomoveis()
        5 -> manutencaoArCondicionados()
        //6 -> relatoriosOperacionais()
        //7 -> sairDoHotel()
        else -> erroMenuPrincipal()
    }
}