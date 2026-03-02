package HoraDeCodar01

fun main(){
    /*
    Escreva um programa em que o usuário informe o seu nome e em seguida
     o programa perguntará a idade do usuário. Agora o programa deve exibir
     a mensagem "Olá, [NomeDoUsuario], sua idade é [idade]".
     */

    println("Digite seu nome: ")
    val nome = readln()

    println("Digite sua idade: ")
    val idade = readln().toInt()

    println("Olá, $nome, sua idade é $idade")
}