package HoraDeCodar08.Animais

import HoraDeCodar08.AbstractClasses.AnimalDeEstimacao

class Gato(override val nome: String) : AnimalDeEstimacao() {
    override val especie: String = "Gato"

}