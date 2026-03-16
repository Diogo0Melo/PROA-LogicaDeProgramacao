package HoraDeCodar08.Animais

import HoraDeCodar08.AbstractClasses.AnimalDeEstimacao

class Coelho(override val nome: String) : AnimalDeEstimacao() {
    override val especie: String = "Coelho"
}