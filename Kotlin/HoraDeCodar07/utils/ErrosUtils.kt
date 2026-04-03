package HoraDeCodar07.utils

import HoraDeCodar07.menus.inicio
import HoraDeCodar07.menus.menuHospedes

fun erroMenuPrincipal() {
    println("Por favor, informe um número entre 1 e 7.")
    return inicio()
}

fun erroMenuHospedes() {
    println("Por favor, informe um número entre 1 e 7.")
    return menuHospedes()
}

fun voltarAoMenuPrincipal() {
    println("Retornando ao menu principal.")
    pausarFluxo()
    inicio()
}