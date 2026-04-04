package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Parrot(override val name: String) : Pet() {
    override val species: String = "Papagaio"

}