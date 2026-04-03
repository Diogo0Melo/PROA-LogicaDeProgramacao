package HoraDeCodar07.hospedes

import HoraDeCodar07.menus.menuHospedes
import HoraDeCodar07.utils.pausarFluxo

fun listarHospedes() {
    println("LISTA DE HÓSPEDES\n")
    val listaHospedes = HospedesRepositorio.listarHospedes()

    listaHospedes?.forEachIndexed { indice, hospede ->
        println("[${indice + 1}] Nome: ${hospede.nome}, Quarto: ${hospede.quarto?.numero ?: "Não hospedado"}, Data/Hora do cadastro: ${hospede.dataCadastro}")
    } ?: println("Nenhum hóspede cadastrado.")

    pausarFluxo()
    return menuHospedes()
}

fun listarHospedesSemReserva(){
    println("LISTA DE HÓSPEDES SEM RESERVA\n")
    val listaHospedes = HospedesRepositorio.listarHospedesSemReserva()
    listaHospedes?.forEachIndexed { indice, hospede ->
        println("[${indice + 1}] Nome: ${hospede.nome}, Quarto: ${hospede.quarto?.numero ?: "Não hospedado"}, Data/Hora do cadastro: ${hospede.dataCadastro}")
    } ?: println("Nenhum hóspede cadastrado.")

    pausarFluxo()
    return
}