package HoraDeCodar07.ExerciciosSeparados

const val NOME_HOTEL = "Hotel Tasokare"
const val SENHA_HOTEL = 2678
val QUARTOS = cadastrarQuartos()
val nomeFuncionario: String = loginFuncionario()

fun main() {
    // Função principal que chama a função inicio().
    inicio()
}

fun inicio() {
    print("Bem vindo ao $NOME_HOTEL!\n")
    println("1 - Reservar Quarto; 2 - Cadastrar Hóspedes;")
    println("Escolha uma opção:")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    return when (escolha) {
        1 -> reservarQuarto()
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> sairDoHotel()
        else -> erro()
    }
}

fun loginFuncionario(): String {
    println("LOGIN FUNCIONÁRIO")
    print("Digite seu nome: ")
    val nome = readln()
    print("Digite a senha: ")
    val senhaTemp = readln().toIntOrNull()
    return when (senhaTemp) {
        SENHA_HOTEL -> {
            println("Bem-vindo ao $NOME_HOTEL, $nome. É um imenso prazer ter você por aqui!")
            enter()
            nome
        }

        else -> {
            println("Senha incorreta. Tente novamente.")
            enter()
            loginFuncionario()
        }
    }

}

fun cadastrarQuartos():Array<Map<String, String>> {
    return Array(20) { index ->
        mapOf("Quarto ${(index + 1).toString().padStart(2, '0')}" to "Livre")
    }
}



fun AbastecimentoDeAutomoveis() {

}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair? S/N")
    val confirma = readln().uppercase()
    when (confirma) {
        "S" -> {
            println("Muito obrigado e até logo, $nomeFuncionario.")
            enter()
        }

        "N" -> inicio()
        else -> {
            println("Opção inválida. Por favor, responda com S ou N.")
            enter()
            sairDoHotel()
        }
    }
}

fun enter() {
    println("Pressione Enter para continuar...")
    readln()
}