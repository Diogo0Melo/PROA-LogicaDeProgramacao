package HoraDeCodar08.Animais

import HoraDeCodar08.AbstractClasses.AnimalDeEstimacao

class Cachorro(override val nome: String) : AnimalDeEstimacao() {
    override val especie = "Cachorro"
}