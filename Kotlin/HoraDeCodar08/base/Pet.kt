package HoraDeCodar08.base

import HoraDeCodar08.utils.pressEnterToContinue

abstract class Pet {
    abstract val species: String
    abstract val name: String
    var age: Int = 0; private set
    var hungerLevel: Int = 50
        private set(value) {
            field = if (value < 0) 0 else value
        }
    var happinessLevel: Int = 50
        private set(value) {
            field = if (value > 100) 100 else value
        }
    var affinityLevel: Int = 0
        private set(value) {
            field = if (value < 0) 0 else if (value > 100) 100 else value
        }
    var tirednessLevel: Int = 0
        private set(value) {
            field = if (value < 0) 0 else value
        }
    var trainingLevel: Int = 0
        private set(value) {
            field = if (value < 0) 0 else if (value > 100) 100 else value
        }
    var natureCallsLevel: Int = 0; private set
    var dirtinessLevel:Int = 0; private set

    fun feed(food: Map<String, Int>, hours: Int) {
        println("Você alimentou $name com ${food.keys.first()}")
        reduceHunger(food)
        increaseTiredness(hours)
        increaseHappiness(hours)
        increaseNatureCalls(hours)
        increaseDirtiness(hours)
        pressEnterToContinue()
        return
    }

    fun play(hours: Int) {
        println("Você brincou com $name durante $hours horas")
        increaseHappiness(hours)
        increaseTiredness(hours)
        increaseHunger(hours)
        increaseAffinity(hours)
        increaseNatureCalls(hours)
        increaseDirtiness(hours)
        pressEnterToContinue()
        return
    }

    fun sleep(hours: Int) {
        println("$name dormiu por $hours horas")
        reduceTiredness(hours)
        reduceHappiness(hours)
        increaseHunger(hours)
        increaseNatureCalls(hours)
        pressEnterToContinue()
        return
    }

    fun checkStatus() {
        println("INFORMAÇÕES ATUAIS DO PET")
        println("Espécie: $species")
        println("Nome: $name")
        println("Idade: $age")
        println("Nível de Fome: $hungerLevel    ------------->   Menor = Melhor")
        println("Nível de Necessidades: $natureCallsLevel   ------------->   Menor = Melhor")
        println("Nível de Felicidade: $happinessLevel   ------------->   Maior = Melhor")
        println("Nível de Afinidade: $affinityLevel   ------------->   Maior = Melhor")
        println("Nível de Cansaço: $tirednessLevel   ---------->   Menor = Melhor")
        println("Nível de Limpeza: $dirtinessLevel   ------------->   Menor = Melhor")
        println("Nível de Treinamento: $trainingLevel   ------------->   Maior = Melhor")
        pressEnterToContinue()
        return
    }

    fun haveBirthday() {
        increaseAge()
        println("Hoje é o aniversário de $name!")
        println("$name agora tem $age anos.")
        pressEnterToContinue()
    }

    fun natureCalls() {
        println("Você levou $name ao banheiro")
        resetNatureCalls()
        pressEnterToContinue()
        return
    }

    fun giveBath(hours: Int){
        println("Você deu banho em $name")
        resetDirtiness()
        reduceHappiness()
        reduceAffinity(hours)
        pressEnterToContinue()
        return
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
        val pointsChanged = hours * 13
        tirednessLevel -= pointsChanged
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

    private fun increaseNatureCalls(hours: Int) {
        val pointsChanged = hours * 5
        natureCallsLevel += pointsChanged
        println("A vontade de ir ao banheiro de $name aumentou em $pointsChanged pontos")
        return
    }

    private fun resetNatureCalls() {
        natureCallsLevel = 0
        println("$name fez suas necessidades e agora está confortável")
        return
    }

    private fun increaseDirtiness(hours: Int){
        val pointsChanged = hours * 5
        dirtinessLevel += pointsChanged
        println("$name ficou $pointsChanged pontos mais sujo")
        return
    }

    private fun resetDirtiness(){
        dirtinessLevel = 0
        println("$name está limpo")
        return
    }

}