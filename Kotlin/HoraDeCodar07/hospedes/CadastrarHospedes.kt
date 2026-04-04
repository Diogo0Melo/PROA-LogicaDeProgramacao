package HoraDeCodar07.hospedes

import HoraDeCodar07.menus.menuHospedes
import HoraDeCodar07.utils.pausarFluxo
import HoraDeCodar07.utils.solicitarNome

fun cadastrarHospedes() {
    println("CADASTRO DE HÓSPEDES\n")
    println("Digite \"PARE\" para finalizar o cadastro.")
    val nomeHospede = solicitarNome("do hóspede")
    if (nomeHospede.uppercase() == "PARE") {
        println("Cadastro finalizado. Retornando ao menu principal.")
        pausarFluxo()
        return menuHospedes()
    }
    val salvoSucesso = HospedesRepositorio.salvar(Hospede(nomeHospede))
    if (salvoSucesso) return cadastrarHospedes()
    println("Limite máximo de 15 hóspedes atingido. Não é possível cadastrar mais nenhum hóspede.")
    pausarFluxo()
    return menuHospedes()
}

