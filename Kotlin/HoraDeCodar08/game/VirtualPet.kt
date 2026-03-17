package HoraDeCodar08.game

import HoraDeCodar08.base.Pet
import HoraDeCodar08.utils.pressEnterToContinue
import HoraDeCodar08.utils.wait
import kotlin.system.exitProcess

class VirtualPet(val pet: Pet, var currentTime: Int = 6) {
    init {
        menu()
    }

    private fun menu() {
        println("Hora atual: ${currentTime.toString().padStart(2, '0')}:00")
        println("O que você gostaria de fazer com seu pet?")
        println("1 - Alimentar ${pet.name}")
        println("2 - Brincar com ${pet.name}")
        println("3 - Dormir com ${pet.name}")
        println("4 - Verificar status de ${pet.name}")
        println("5 - Abandonar ${pet.name} (sair do jogo)")
        val choice = readln().toIntOrNull()
        if (this.currentTime >= 22 && choice !in 3..4) {
            println("A partir das 22h não é possível realizar mais nenhuma tarefa que não seja dormir!")
            pressEnterToContinue()
            return menu()
        }
        val duration = if (choice != null && choice in 2..3) this.requestDuration() else 1
        return when (choice) {
            1 -> {
                wait("ALIMENTANDO", duration)
                pet.feed(mapOf("BiscoitoScooby" to 10), duration)
                this.increaseTime(duration)
                this.menu()
            }

            2 -> {
                wait("BRINCANDO", duration)
                pet.play(duration)
                this.increaseTime(duration)
                this.menu()
            }

            3 -> {
                if (this.currentTime >= 22)
                    finishDay()
                else {
                    wait("DORMINDO", duration)
                    pet.sleep(duration)
                    this.increaseTime(duration)
                }
                this.menu()
            }

            4 -> {
                pet.checkStatus()
                this.menu()
            }

            5 -> {
                println("Você abandonou ${pet.name}. Adeus!")
                exitProcess(0)
            }

            else -> {
                println("Opção inválida, escolha uma opção válida.")
                this.menu()
            }
        }
    }

    private fun requestDuration(): Int {
        println("Por quanto tempo você deseja fazer esta atividade com ${pet.name}?")
        val duration = readln().toIntOrNull()
        if (duration == null || duration <= 0) {
            println("Precisa ser um número inteiro e maior que zero.")
            pressEnterToContinue()
            return this.requestDuration()
        } else if (this.currentTime + duration > 22) {
            println("Você só pode realizar ações com seu pet até as 22h")
            pressEnterToContinue()
            return this.requestDuration()
        }
        return duration
    }

    private fun finishDay(hours: Int = 8) {
        println("Você e ${pet.name} foram dormir até o amanhecer do novo dia!")
        wait("DORMINDO", hours)
        this.pet.sleep(hours)
        this.pet.haveBirthday()
        this.setTime()
        return
    }

    private fun increaseTime(hours: Int = 1) {
        this.currentTime += hours
        return
    }

    private fun setTime(hours: Int = 6) {
        this.currentTime = hours
        return
    }
}