package HoraDeCodar07.utils

import AntigoHC07.enter
import AntigoHC07.menuHospedes
import HoraDeCodar07.menus.inicio

fun erroMenuPrincipal() {
    println("Por favor, informe um número entre 1 e 6.")
    return inicio()
}

fun erroMenuHospedes() {
    println("Por favor, informe um número entre 1 e 5.")
    return menuHospedes()
}

fun voltarAoMenuPrincipal() {
    println("Retornando ao menu principal.")
    enter()
    inicio()
}