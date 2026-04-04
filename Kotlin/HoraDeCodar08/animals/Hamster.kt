package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Hamster(override val name: String) : Pet() {
    override val species: String = "Hamster"
}