package HoraDeCodar07.ExerciciosSeparados

// 2) Como soletra?

fun cadastrarHospedes() {
    println("CADASTRO DE HÓSPEDES\n")
    val valorDiaria = solicitarValorDiaria()
    val hospedes: List<Map<String, Int>> = solicitarHospedes() ?: return inicio()

    val valorTotal = calcularValorTotalHospedagem(valorDiaria, hospedes)

    println("$nomeFuncionario, o valor total das hospedagens é: R$${"%.2f".format(valorTotal.keys.first())}; ${valorTotal.values.first()[0]} gratuidades e ${valorTotal.values.first()[1]} meias entradas.")

    enter()
    return inicio()
}

fun solicitarHospedes(): List<Map<String, Int>>? {
    val hospedes = mutableListOf<Map<String, Int>>()
    while (true) {
        println("Digite 'PARE' para finalizar o cadastro de hóspedes.")
        val nomeHospede = solicitarNomeHospede()

        if (nomeHospede.uppercase() == "PARE") return hospedes.ifEmpty { return null }

        val idadeHospede = solicitarIdadeHospede()

        println("$nomeHospede cadastrada(o) com sucesso.")
        hospedes.add(mapOf(nomeHospede to idadeHospede))
        enter()
    }
}

fun solicitarIdadeHospede(): Int {
    println("Qual a idade do Hóspede? ")
    val idadeHospede = readln().toIntOrNull()
    return if (idadeHospede != null && idadeHospede > 0) {
        idadeHospede
    } else {
        println("Idade inválida. Tente novamente.")
        solicitarIdadeHospede()
    }
}

fun calcularValorTotalHospedagem(valorDiaria: Double, hospedes: List<Map<String, Int>>): Map<Double, List<Int>> {
    var valorTotal = 0.0
    var gratuidades = 0
    var meiasEntradas = 0

    hospedes.forEach {
        val idade = it.values.first()
        when {
            idade < 6 -> gratuidades++
            idade > 60 -> {
                valorTotal += valorDiaria * 0.5
                meiasEntradas++
            }
            else -> valorTotal += valorDiaria
        }
    }
    return mapOf(valorTotal to listOf(gratuidades, meiasEntradas))
}