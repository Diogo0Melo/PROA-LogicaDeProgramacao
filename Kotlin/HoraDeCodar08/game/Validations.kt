package HoraDeCodar08.game

import HoraDeCodar08.base.Pet

class Validations {
    fun validateGameOver(pet: Pet): Map<String, String> {
        if (pet.hungerLevel >= 100) {
            return mapOf("reason" to "Seu ${pet.species} ${pet.name} morreu de fome!")
        } else if (pet.tirednessLevel >= 100) {
            return mapOf("reason" to "Seu ${pet.species} ${pet.name} morreu de cansaço!")
        }
        return mapOf()
    }
}