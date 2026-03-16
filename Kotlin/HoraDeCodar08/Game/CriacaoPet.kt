package HoraDeCodar08.Game

import HoraDeCodar08.AbstractClasses.AnimalDeEstimacao
import HoraDeCodar08.Animais.Cachorro
import HoraDeCodar08.Animais.Coelho
import HoraDeCodar08.Animais.Gato

fun escolherPet() {
    println("BEM VINDO AO JOGO DE PET VIRTUAL!")
    println("Escolha seu pet:")
    println("Cachorro - Gato - Coelho")
    val escolha = readln().lowercase()
    return when (escolha.lowercase()) {
        "cachorro" -> ecolherNome("cachorro")
        "gato" -> ecolherNome("gato")
        "coelho" -> ecolherNome("coelho")
        else -> {
            println("Opção inválida, escolha um pet válido.")
            escolherPet()
        }
    }
}

fun ecolherNome(especie: String) {
    println("Escolha um nome para seu $especie:")
    val nome = readln().trim().ifEmpty { readln() }
    return when (especie) {
        "cachorro" -> iniciarVirtualPet(Cachorro(nome))
        "gato" -> iniciarVirtualPet(Gato(nome))
        "coelho" -> iniciarVirtualPet(Coelho(nome))
        else -> throw IllegalArgumentException("Espécie inválida.") // Nunca deve acontecer, pois a função escolherPet já valida as opções
    }
}

fun iniciarVirtualPet(pet: AnimalDeEstimacao) {
    println("Parabéns! Você escolheu um ${pet.especie} chamado ${pet.nome}!")
    VirtualPet(pet)
    return
}
