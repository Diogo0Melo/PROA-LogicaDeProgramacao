package HoraDeCodar07.eventos

object AuditoriosRepositorio {
    val auditorios = listOf(
        Auditorio("Auditório laranja", 150, 70),
        Auditorio("Auditório colorado", 350, 0)
    )

    fun salvarReserva(auditorio: Auditorio, diaReserva: String): Boolean = auditorio.reservas.add(diaReserva)

    fun listarReservas(): List<String> = auditorios.flatMap { it.reservas }

}