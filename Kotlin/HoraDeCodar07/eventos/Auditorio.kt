package HoraDeCodar07.eventos

class Auditorio(
    val nome: String,
    val capacidade: Int,
    val capacidadeAdicional: Int,
    val reservas: MutableList<String> = mutableListOf()
)