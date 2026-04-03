package HoraDeCodar07.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatarDataHora(dataHora: LocalDateTime): String {
    val formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    return dataHora.format(formatador)
}