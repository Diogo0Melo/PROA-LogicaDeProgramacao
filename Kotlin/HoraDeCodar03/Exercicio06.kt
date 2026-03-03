package HoraDeCodar03

fun main(){
    /*
   Escreva um programa para ler 2 notas de um aluno, calcular e imprimir a média final. Considere que a nota de aprovação é 9,5. Logo após escrever a mensagem "Calcular a média de outro aluno Sim/Não?" e solicitar um resposta. Se a resposta for "S", o programa deve ser executado novamente, caso contrário deve ser encerrado exibindo a quantidade de alunos aprovados.
    */
    do{
        println("Digite a primeira nota do aluno: ")
        val nota1: Double = readln().toDouble()

        println("Digite a segunda nota do aluno: ")
        val nota2: Double = readln().toDouble()

        val resultado = (nota1 + nota2) / 2.0
        if(resultado >= 9.5) println("Aluno aprovado!")
        else println("Aluno reprovado!")

        println("Calcular a média de outro aluno Sim/Não?")
        val opcao = readln()
    }while (opcao == "s" || opcao == "S" || opcao == "sim" || opcao == "SIM" || opcao == "sIm" || opcao == "SiM" || opcao == "sIM" || opcao == "Sim" || opcao == "SIm" || opcao == "siM")

}