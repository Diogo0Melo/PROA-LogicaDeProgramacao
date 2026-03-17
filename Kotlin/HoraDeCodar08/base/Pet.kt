package HoraDeCodar08.base

import HoraDeCodar08.utils.pressEnterToContinue

abstract class Pet {
    abstract val species: String
    abstract val name: String
    var age: Int = 0; private set
    var hungerLevel: Int = 50; private set
    var happinessLevel: Int = 50; private set
    var affinityLevel: Int = 0; private set
    var tirednessLevel: Int = 0; private set
    var trainingLevel: Int = 0; private set

    fun feed(food: Map<String, Int>, hours: Int) {
        println("Você alimentou $name com ${food.keys.first()}")
        reduceHunger(food)
        increaseTiredness()
        increaseHappiness()
        pressEnterToContinue()
        return
    }

    fun play(hours: Int) {
        println("Você brincou com $name durante $hours horas")
        increaseHappiness(hours)
        increaseTiredness(hours)
        increaseHunger(hours)
        increaseAffinity(hours)
        pressEnterToContinue()
        return
    }

    fun sleep(hours: Int) {
        println("$name dormiu por $hours horas")
        reduceTiredness(hours)
        increaseHunger(hours)
        pressEnterToContinue()
        return
    }

    fun checkStatus() {
        println("INFORMAÇÕES ATUAIS DO PET")
        println("Espécie: $species")
        println("Nome: $name")
        println("Nível de Fome: $hungerLevel")
        println("Nível de Felicidade: $happinessLevel")
        println("Nível de Afinidade: $affinityLevel")
        println("Nível de Cansaço: $tirednessLevel")
        println("Nível de Treinamento: $trainingLevel")
        pressEnterToContinue()
        return
    }

    fun haveBirthday() {
        this.increaseAge()
        println("Hoje é o aniversário de $name!")
        println("$name agora tem $age anos.")
        pressEnterToContinue()
    }

    private fun increaseAge() = age++

    private fun increaseHunger(hours: Int) {
        val pointsChanged = hours * 5
        hungerLevel += pointsChanged
        println("A fome de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceHunger(food: Map<String, Int>) {
        val pointsChanged = food.values.first()
        hungerLevel -= pointsChanged
        println("A fome de $name reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseHappiness(hours: Int = 1) {
        val pointsChanged = hours * 5
        happinessLevel += pointsChanged
        println("A felicidade de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceHappiness(hours: Int = 1) {
        val pointsChanged = hours * 3
        happinessLevel -= pointsChanged
        println("A felicidade de $name reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseTiredness(hours: Int = 1) {
        val pointsChanged = hours * 10
        tirednessLevel += pointsChanged
        println("O cansaço de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceTiredness(hours: Int) {
        val pointsChanged = hours * 5
        tirednessLevel += pointsChanged
        println("O cansaço de $name reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseAffinity(hours: Int) {
        val pointsChanged = hours * 5
        affinityLevel += pointsChanged
        println("A afinidade de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceAffinity(hours: Int) {
        val pointsChanged = hours * 5
        affinityLevel -= pointsChanged
        println("A afinidade de $name reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseTraining(hours: Int) {
        val pointsChanged = hours * 5
        trainingLevel += pointsChanged
        println("O treinamento de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceTraining(hours: Int) {
        val pointsChanged = hours * 5
        trainingLevel -= pointsChanged
        println("O treinamento de $name reduziu em $pointsChanged pontos")
        return
    }

}