package HoraDeCodar07.eventos

object AuditoriosRepositorio {
    val auditorios = arrayOf(
        Auditorio("Auditório laranja", 150, 70),
        Auditorio("Auditório colorado", 350, 0)
    )

    fun salvarReserva(auditorio: Auditorio, diaReserva: String): Boolean {
        return auditorio.reservas.add(diaReserva)
    }
}