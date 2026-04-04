package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Duck(override val name: String) : Pet() {
    override val species: String = "Pato"
}