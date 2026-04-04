package HoraDeCodar08.animals

import HoraDeCodar08.base.Pet

class Cockatiel(override val name: String) : Pet() {
    override val species: String = "Calopsita"
}