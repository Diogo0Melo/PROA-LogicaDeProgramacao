package HoraDeCodar05

// Regex: apenas letras Unicode (inclui acentos) e exatamente um espaço entre cada parte do nome
private val NOME_REGEX = Regex("""^\p{L}+(?: \p{L}+)*$""")

var contasBancarias: MutableList<ContaBancaria> = mutableListOf()
var contasCriadas:Int = 0

fun main() {
    telaPrincipal()
}

fun telaPrincipal() {
    println("Bem-vindo ao Banco Tchan!")
    println("1. Criar conta")
    println("2. Acessar conta")
    println("3. Sair")
    do{
        val opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> criarConta()
            2 -> acessarConta()
            0 -> sair()
            else -> println("Opção inválida. Tente novamente.")
        }
    }while (true)
}

fun criarConta() {
    println("CRIAÇÃO DE CONTA\n")

    val nome = pedirNome()
    val numeroConta = gerarNumeroConta()
    val senha = criarSenha()

    val conta = ContaBancaria(nome, numeroConta, senha)
    contasBancarias.add(conta)
    contasCriadas++

    println("Conta criada com sucesso! Número da conta: $numeroConta")
}

fun pedirNome(): String {
    while (true) {
        print("Digite seu nome: ")
        val input = readln().trim()

        if (input.isEmpty()) {
            println("Nome não pode ser vazio. Tente novamente.")
            continue
        }

        if (!NOME_REGEX.matches(input)) {
            println("Nome inválido. Use apenas letras (incluindo acentos) e um único espaço entre as partes do nome. Ex: Davilson Metronomo")
            continue
        }

        return input
    }
}

// Gera um número de conta simples (5 dígitos)
fun gerarNumeroConta(): Int {

}

// Cria uma senha solicitando ao usuário (4 dígitos numéricos)
fun criarSenha(): Int {
    while (true) {
        print("Escolha uma senha numérica de 4 dígitos: ")
        val s = readLine()?.trim() ?: ""
        if (s.matches(Regex("^\\d{4}$"))) {
            return s.toInt()
        }
        println("Senha inválida. Deve conter exatamente 4 dígitos.")
    }
}

data class ContaBancaria(
    val nome: String,
    val numeroConta: Int,
    val senha: Int,
    var saldoEmConta: Double = 0.0,
    var saldoEmMaos: Double = 0.0,
    var extrato: MutableList<String> = mutableListOf()
) {

    fun depositar(valor: Double) {
        saldoEmConta += valor
        saldoEmMaos -= valor
        extrato.add("Depósito: R$ $valor")
    }

    fun sacar(valor: Double) {
        saldoEmConta -= valor
        saldoEmMaos += valor
        extrato.add("Saque: R$ $valor")
    }

    fun trabalhar(valor: Double) {
        saldoEmMaos += valor
    }

    fun transferir(destino: ContaBancaria, valor: Double) {
        saldoEmConta -= valor
        destino.saldoEmConta += valor
        extrato.add("Transferência enviada: R$ $valor para ${destino.nome}")
        destino.extrato.add("Transferência recebida: R$ $valor de ${this.nome}")
    }

}