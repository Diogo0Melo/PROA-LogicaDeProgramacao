package HoraDeCodar08.game

import HoraDeCodar08.base.Pet

class Validation(private val pet: Pet) {
    fun validateGameOver(): Map<String, String> {
        return if (pet.hungerLevel >= 100) {
            mapOf("whatHappened" to "gameOver", "reason" to "Seu ${pet.species} ${pet.name} morreu de fome!")
        } else if (pet.tirednessLevel >= 100) {
            mapOf("whatHappened" to "gameOver", "reason" to "Seu ${pet.species} ${pet.name} morreu de cansaço!")
        } else if (pet.happinessLevel <= 0) {
            mapOf("whatHappened" to "gameOver", "reason" to "Seu ${pet.species} ${pet.name} morreu de tristeza!")
        } else if (pet.natureCallsLevel >= 100) {
            mapOf(
                "whatHappened" to "gameOver",
                "reason" to "Seu ${pet.species} ${pet.name} explodiu porquê não foi ao banheiro!"
            )
        } else mapOf()
    }

    fun validateWin(): Map<String, String> {
        return if (pet.age >= 50) mapOf(
            "whatHappened" to "win",
            "reason" to "Parabéns! Você conseguiu manter o seu ${pet.species}${pet.name} por 50 anos! Isso é uma vitória e o seu trabalho aqui está concluído."
        )
        else mapOf()
    }
}