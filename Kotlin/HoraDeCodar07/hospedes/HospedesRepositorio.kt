package HoraDeCodar07.hospedes

import HoraDeCodar07.reservas.Quarto

object HospedesRepositorio {
    val listaHospedes = mutableListOf<Hospede>()

    fun salvar(hospede: Hospede): Boolean {
        if (listaHospedes.size >= 15) return false
        return listaHospedes.add(hospede)
    }

    fun pesquisarPorNomeExato(nome: String): Hospede? {
        val hospede = listaHospedes.find { it.nome.equals(nome, ignoreCase = true) }
        if (hospede != null) return hospede
        return null
    }

    fun pesquisarPorPrefixo(nome: String): List<Hospede>? {
        val hospedes = listaHospedes.filter { it.nome.contains(nome, ignoreCase = true) }
        if (hospedes.isNotEmpty()) return hospedes
        return null
    }

    fun listarHospedes(): List<Hospede>? =
        listaHospedes.map { it }.sortedBy { it.nome.uppercase() }.ifEmpty { return null }

    fun atualizarNomeHospede(hospede: Hospede, novoNome: String): Map<String, String> {
        val nomeAntigo = hospede.nome
        hospede.nome = novoNome
        return mapOf("nomeAntigo" to nomeAntigo, "novoNome" to novoNome)
    }

    fun deletarHospede(hospede: Hospede): Boolean {
        return listaHospedes.remove(hospede)
    }

    fun adicionarQuarto(hospede: Hospede, quarto: Quarto): Boolean {
        hospede.quarto = quarto
        return true
    }

    fun listarHospedesSemReserva(): List<Hospede>? = listaHospedes.filter { it.quarto == null }.ifEmpty { null }

}