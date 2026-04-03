package HoraDeCodar07.hospedes

object HospedesRepositorio {
    val listaHospedes = mutableListOf<Hospede>()

    fun salvar(hospede: Hospede): Boolean {
        if (listaHospedes.size >= 15) return false
        listaHospedes.add(hospede)
        return true
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
}