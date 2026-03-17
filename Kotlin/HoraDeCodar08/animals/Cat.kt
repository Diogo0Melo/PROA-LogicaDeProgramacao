package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Cat(override val name: String) : Pet() {
    override val species: String = "Gato"

}