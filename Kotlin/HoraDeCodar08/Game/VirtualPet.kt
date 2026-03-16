package HoraDeCodar08.Game

import HoraDeCodar08.AbstractClasses.AnimalDeEstimacao
import kotlin.system.exitProcess

class VirtualPet(val pet: AnimalDeEstimacao) {
    init {
        menu()
    }

    fun menu() {
        println("O que você gostaria de fazer com seu pet?")
        println("1 - Alimentar ${pet.nome}")
        println("2 - Brincar com ${pet.nome}")
        println("3 - Dormir com ${pet.nome}")
        println("4 - Verificar status de ${pet.nome}")
        println("5 - Abandonar ${pet.nome} (sair do jogo)")
        val escolha = readln().toIntOrNull()
        return when (escolha) {
            1 -> {
                pet.alimentar(mapOf("BiscoitoScooby" to 10))
                menu()
            }
            2 -> {
                pet.brincar(1)
                menu()
            }
            3 -> {
                pet.dormir(8)
                menu()
            }
            4 -> {
                pet.verificarStatus()
                menu()
            }
            5 -> {
                println("Você abandonou ${pet.nome}. Adeus!")
                exitProcess(0)
            }
            else -> {
                println("Opção inválida, escolha uma opção válida.")
                menu()
            }
        }
    }
}