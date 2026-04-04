package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Dog(override val name: String) : Pet() {
    override val species = "Cachorro"
}