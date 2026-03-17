package HoraDeCodar08.game

import HoraDeCodar08.base.Pet
import HoraDeCodar08.main
import HoraDeCodar08.utils.pressEnterToContinue
import HoraDeCodar08.utils.wait
import kotlin.system.exitProcess

class VirtualPet(val pet: Pet) {
    var currentTime: Int = 6; private set

    init {
        menu()
    }

    private fun menu() {
        val gameOver = Validations().validateGameOver(pet)
        if (gameOver.isNotEmpty()) finishGame(gameOver)
        println("Hora atual: ${currentTime.toString().padStart(2, '0')}:00")
        println("O que você gostaria de fazer com seu pet?")
        println("1 - Alimentar ${pet.name}")
        println("2 - Brincar com ${pet.name}")
        println("3 - Descansar com ${pet.name}")
        println("4 - Verificar status de ${pet.name}")
        println("5 - Dormir com ${pet.name} (encerrar o dia)")
        println("6 - Abandonar ${pet.name} (sair do jogo)")
        val choice = readln().toIntOrNull()
        if (currentTime >= 22 && choice !in 3..4) {
            println("A partir das 22h não é possível realizar mais nenhuma tarefa que não seja dormir!")
            pressEnterToContinue()
            return menu()
        }
        val duration = if (choice != null && choice in 2..3) this.requestDuration() else 1
        return when (choice) {
            1 -> {
                wait("ALIMENTANDO", duration)
                pet.feed(mapOf("BiscoitoScooby" to 10), duration)
                increaseTime(duration)
                menu()
            }

            2 -> {
                wait("BRINCANDO", duration)
                pet.play(duration)
                increaseTime(duration)
                menu()
            }

            3 -> {
                wait("DESCANSANDO", duration)
                pet.sleep(duration)
                increaseTime(duration)
                menu()
            }

            4 -> {
                pet.checkStatus()
                menu()
            }

            5 -> {
                if (currentTime < 22) {
                    println("Ainda há tempo para aproveitar.")
                    println("Volte à interagir com seu pet!!!")
                    pressEnterToContinue()
                    menu()
                } else {
                    println("Você e ${pet.name} foram dormir até o amanhecer do novo dia!")
                    wait("DORMINDO", 8)
                    finishDay()
                    menu()
                }

            }

            6 -> {
                println("Você abandonou ${pet.name}. Adeus!")
                exitProcess(0)
            }

            else -> {
                println("Opção inválida, escolha uma opção válida.")
                menu()
            }
        }
    }

    private fun requestDuration(): Int {
        println("Por quanto tempo você deseja realizar essa interação com ${pet.name}?")
        val duration = readln().toIntOrNull()
        if (duration == null || duration <= 0) {
            println("Precisa ser um número inteiro e maior que zero.")
            pressEnterToContinue()
            return requestDuration()
        } else if (currentTime + duration > 22) {
            println("Você só pode realizar ações com seu pet até as 22h")
            pressEnterToContinue()
            return requestDuration()
        }
        return duration
    }

    private fun finishDay(hours: Int = 8) {
        pet.sleep(hours)
        pet.haveBirthday()
        setTime()
        return
    }

    private fun finishGame(gameOver: Map<String, String>) {
        println(gameOver["reason"])
        pressEnterToContinue()
        return main()
    }

    private fun increaseTime(hours: Int = 1) = currentTime.plus(hours)

    private fun setTime(hours: Int = 6) {
        currentTime = hours
        return
    }
}