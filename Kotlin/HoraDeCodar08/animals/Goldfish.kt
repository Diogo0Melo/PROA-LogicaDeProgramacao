package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Goldfish(override val name: String) : Pet() {
    override val species: String = "Peixe Dourado"
}