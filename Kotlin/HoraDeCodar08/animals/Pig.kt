package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Pig(override val name: String) : Pet() {
    override val species: String = "Porco"
}