package HoraDeCodar07.ar_condicionado

object EmpresasRepositorio {
    val empresas: MutableList<Empresa> = mutableListOf()
    val historico: MutableList<Empresa> = mutableListOf()

    fun salvarEmpresa(empresa: Empresa): Boolean {
        return empresas.add(empresa)
    }
    fun calcularEmpresaMaisBarata(): Empresa? {
        if(empresas.isEmpty()) return null
        return empresas.minBy { it.valorTotal }
    }
    fun limpar(): Boolean{
        historico.addAll(empresas)
        empresas.clear()
        return true
    }
}