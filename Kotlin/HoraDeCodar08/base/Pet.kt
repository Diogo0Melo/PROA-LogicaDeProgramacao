package HoraDeCodar08.base

import HoraDeCodar08.utils.pressEnterToContinue

abstract class Pet {
    abstract val species: String
    abstract val name: String
    private var age: Int = 0
    private var hungerLevel: Int = 50
    private var happinessLevel: Int = 50
    private var affinityLevel: Int = 0
    private var tirednessLevel: Int = 0
    private var trainingLevel: Int = 0


    fun feed(food: Map<String, Int>) {
        println("Você alimentou ${this.name} com ${food.keys.first()}")
        this.reduceHunger(food)
        this.increaseTiredness()
        this.increaseHappiness()
        pressEnterToContinue()
        return
    }

    fun play(hours: Int) {
        println("Você brincou com ${this.name} durante $hours horas")
        this.increaseHappiness(hours)
        this.increaseTiredness(hours)
        this.increaseHunger(hours)
        this.increaseAffinity(hours)
        pressEnterToContinue()
        return
    }

    fun sleep(hours: Int) {
        println("${this.name} dormiu por $hours horas")
        this.reduceTiredness(hours)
        this.increaseHunger(hours)
        pressEnterToContinue()
        return
    }

    fun checkStatus() {
        println("INFORMAÇÕES ATUAIS DO PET")
        println("Espécie: ${this.species}")
        println("Nome: ${this.name}")
        println("Nível de Fome: ${this.hungerLevel}")
        println("Nível de Felicidade: ${this.happinessLevel}")
        println("Nível de Afinidade: ${this.affinityLevel}")
        println("Nível de Cansaço: ${this.tirednessLevel}")
        println("Nível de Treinamento: ${this.trainingLevel}")
        pressEnterToContinue()
        return
    }

    fun haveBirthday() {
        this.increaseAge()
        println("Hoje é o aniversário de ${this.name}!")
        println("${this.name} agora tem ${this.age} anos.")
        pressEnterToContinue()
    }

    private fun increaseAge() = age++

    private fun increaseHunger(hours: Int) {
        val pointsChanged = hours * 5
        this.hungerLevel += pointsChanged
        println("A fome de ${this.name} aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceHunger(food: Map<String, Int>) {
        val pointsChanged = food.values.first()
        this.hungerLevel -= pointsChanged
        println("A fome de ${this.name} reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseHappiness(hours: Int = 1) {
        val pointsChanged = hours * 5
        this.happinessLevel += pointsChanged
        println("A felicidade de ${this.name} aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceHappiness(hours: Int = 1) {
        val pointsChanged = hours * 5
        this.happinessLevel -= pointsChanged
        println("A felicidade de ${this.name} reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseTiredness(hours: Int = 1) {
        val pointsChanged = hours * 5
        this.tirednessLevel += pointsChanged
        println("O cansaço de ${this.name} aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceTiredness(hours: Int) {
        val pointsChanged = hours * 5
        this.tirednessLevel += pointsChanged
        println("O cansaço de ${this.name} reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseAffinity(hours: Int) {
        val pointsChanged = hours * 5
        this.affinityLevel += pointsChanged
        println("A afinidade de ${this.name} aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceAffinity(hours: Int) {
        val pointsChanged = hours * 5
        this.affinityLevel -= pointsChanged
        println("A afinidade de ${this.name} reduziu em $pointsChanged pontos")
        return
    }

    private fun increaseTraining(hours: Int) {
        val pointsChanged = hours * 5
        this.trainingLevel += pointsChanged
        println("O treinamento de ${this.name} aumentou em $pointsChanged pontos")
        return
    }

    private fun reduceTraining(hours: Int) {
        val pointsChanged = hours * 5
        this.trainingLevel -= pointsChanged
        println("O treinamento de ${this.name} reduziu em $pointsChanged pontos")
        return
    }

}