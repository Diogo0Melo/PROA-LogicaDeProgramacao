package HoraDeCodar08.game

import HoraDeCodar08.animals.*
import HoraDeCodar08.base.Pet
import HoraDeCodar08.utils.pressEnterToContinue
import HoraDeCodar08.utils.wait

fun choosePet() {
    println("BEM VINDO AO JOGO DE PET VIRTUAL!")
    println("Escolha seu pet:")
    println("Cachorro - Gato - Coelho - Calopsita - Papagaio - Galinha - Doninha")
    println("Pato - Peixe Dourado - Ganso - Hamster - Cavalo - Porco - Furão")
    val choice = readln().lowercase()
    return when (choice.lowercase()) {
        "cachorro" -> choosePetName("cachorro")
        "gato" -> choosePetName("gato")
        "coelho" -> choosePetName("coelho")
        "calopsita" -> choosePetName("calopsita")
        "papagaio" -> choosePetName("papagaio")
        "galinha" -> choosePetName("galinha")
        "doninha" -> choosePetName("doninha")
        "pato" -> choosePetName("pato")
        "peixe dourado" -> choosePetName("peixe dourado")
        "ganso" -> choosePetName("ganso")
        "hamster" -> choosePetName("hamster")
        "cavalo" -> choosePetName("cavalo")
        "porco" -> choosePetName("porco")
        "furão" -> choosePetName("furão")
        else -> {
            println("Opção inválida, escolha um pet válido.")
            choosePet()
        }
    }
}

fun choosePetName(species: String) {
    println("Escolha um nome para seu $species:")
    val name = readln().trim().ifEmpty { readln() }
    return when (species) {
        "cachorro" -> runVirtualPet(Dog(name))
        "gato" -> runVirtualPet(Cat(name))
        "coelho" -> runVirtualPet(Rabbit(name))
        "calopsita" -> runVirtualPet(Cockatiel(name))
        "papagaio" -> runVirtualPet(Parrot(name))
        "galinha" -> runVirtualPet(Chicken(name))
        "Doninha" -> runVirtualPet(Weasel(name))
        "pato" -> runVirtualPet(Duck(name))
        "peixe dourado" -> runVirtualPet(Goldfish(name))
        "ganso" -> runVirtualPet(Goose(name))
        "hamster" -> runVirtualPet(Hamster(name))
        "cavalo" -> runVirtualPet(Horse(name))
        "porco" -> runVirtualPet(Pig(name))
        "Furão" -> runVirtualPet(Ferret(name))
        else -> throw IllegalArgumentException("Espécie inválida.") // Nunca deve acontecer, pois a função escolherPet já valida as opções
    }
}

fun runVirtualPet(pet: Pet) {
    wait("ADOTANDO", 5)
    println("Parabéns! Você adotou um ${pet.species} chamado ${pet.name}!")
    pressEnterToContinue()
    VirtualPet(pet)
    return
}
