package HoraDeCodar08.game

import HoraDeCodar08.animals.Cat
import HoraDeCodar08.animals.Dog
import HoraDeCodar08.animals.Rabbit
import HoraDeCodar08.base.Pet

fun choosePet() {
    println("BEM VINDO AO JOGO DE PET VIRTUAL!")
    println("Escolha seu pet:")
    println("Cachorro - Gato - Coelho")
    val choice = readln().lowercase()
    return when (choice.lowercase()) {
        "cachorro" -> setPetName("cachorro")
        "gato" -> setPetName("gato")
        "coelho" -> setPetName("coelho")
        else -> {
            println("Opção inválida, escolha um pet válido.")
            choosePet()
        }
    }
}

fun setPetName(species: String) {
    println("Escolha um nome para seu $species:")
    val name = readln().trim().ifEmpty { readln() }
    return when (species) {
        "cachorro" -> runVirtualPet(Dog(name))
        "gato" -> runVirtualPet(Cat(name))
        "coelho" -> runVirtualPet(Rabbit(name))
        else -> throw IllegalArgumentException("Espécie inválida.") // Nunca deve acontecer, pois a função escolherPet já valida as opções
    }
}

fun runVirtualPet(pet: Pet) {
    println("Parabéns! Você escolheu um ${pet.species} chamado ${pet.name}!")
    VirtualPet(pet)
    return
}
