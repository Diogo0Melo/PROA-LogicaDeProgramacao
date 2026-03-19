package HoraDeCodar08.game

import HoraDeCodar08.base.Pet
import HoraDeCodar08.main
import HoraDeCodar08.utils.pressEnterToContinue
import HoraDeCodar08.utils.wait
import kotlin.system.exitProcess

class VirtualPet(val pet: Pet) {
    var currentTime: Int = 6; private set
    private val validations = Validation(pet)

    init {
        menu()
    }

    private fun menu() {
        val gameOver = validations.validateGameOver()
        val win = validations.validateWin()
        if (gameOver.isNotEmpty()) finishGame(gameOver)
        else if (win.isNotEmpty()) finishGame(win)
        println("Hora atual: ${currentTime.toString().padStart(2, '0')}:00")
        println("O que você gostaria de fazer com seu pet?")
        println("1 - Alimentar ${pet.name}")
        println("2 - Brincar com ${pet.name}")
        println("3 - Descansar com ${pet.name}")
        println("4 - Levar ${pet.name} ao banheiro")
        println("5 - Dar banho em ${pet.name}")
        println("6 - Dormir com ${pet.name} (encerrar o dia)")
        println("7 - Verificar status de ${pet.name}")
        println("8 - Abandonar ${pet.name} (sair do jogo)")
        val choice = readln().toIntOrNull()
        if (currentTime >= 22 && choice !in 6..8) {
            println("A partir das 22h não é possível realizar mais nenhuma tarefa que não seja dormir!")
            pressEnterToContinue()
            return menu()
        }
        val duration = if (choice != null && choice in 2..3) this.requestDuration() else 1
        return when (choice) {
            1 -> feed(duration)

            2 -> play(duration)

            3 -> rest(duration)

            4 -> goToBathroom(duration)

            5 -> giveBath(duration)

            6 -> sleep(8)

            7 -> checkStatus()

            8 -> exit()

            else -> error()
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

    private fun finishGame(reason: Map<String, String>) {
        if (reason["whatHappened"] == "gameOver") println(reason["reason"])
        else if (reason["whatHappened"] == "win") println(reason["reason"])
        pressEnterToContinue()
        return main()
    }

    private fun increaseTime(hours: Int = 1) {
        currentTime += hours
        return
    }

    private fun setTime(hours: Int = 6) {
        currentTime = hours
        return
    }

    private fun feed(duration: Int) {
        wait("ALIMENTANDO", duration)
        pet.feed(mapOf("BiscoitoScooby" to 10), duration)
        increaseTime(duration)
        menu()
    }

    private fun play(duration: Int) {
        wait("BRINCANDO", duration)
        pet.play(duration)
        increaseTime(duration)
        menu()
    }

    private fun rest(duration: Int) {
        wait("DESCANSANDO", duration)
        pet.sleep(duration)
        increaseTime(duration)
        menu()
    }

    private fun goToBathroom(duration: Int) {
        wait("FAZENDO NECESSIDADES", duration)
        pet.natureCalls()
        increaseTime(duration)
        menu()
    }

    private fun giveBath(duration: Int) {
        wait("DANDO BANHO", duration)
        pet.giveBath(duration)
        increaseTime(duration)
        menu()
    }

    private fun sleep(duration: Int) {
        if (currentTime < 22) {
            println("Ainda há tempo para aproveitar.")
            println("Volte à interagir com seu pet!!!")
            pressEnterToContinue()
            menu()
        } else {
            println("Você e ${pet.name} foram dormir até o amanhecer do novo dia!")
            wait("DORMINDO", duration)
            finishDay()
            menu()
        }
    }

    private fun checkStatus() {
        pet.checkStatus()
        menu()
    }

    private fun exit() {
        println("Você abandonou ${pet.name}. Adeus!")
        exitProcess(0)
    }

    private fun error() {
        println("Opção inválida, escolha uma opção válida.")
        menu()
    }
}