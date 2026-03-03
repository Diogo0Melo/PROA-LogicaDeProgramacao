package HoraDeCodar03

fun main(){
    /*
    Escreva um algoritmo para ler as notas de avaliações de um aluno, calcule e imprima a média (simples) desse aluno. Só devem ser aceitos valores válidos durante a leitura (0 a 10) para cada nota. São 6 notas ao total.
    Caso o valor informado para qualquer uma das notas esteja fora do limite estabelecido, deve ser solicitado um novo valor ao usuário.
     */

    val valores = IntArray(6)
    valores.forEachIndexed { index, d ->
        do{
            println("Digite o ${index+1}° valor: ")
            val valor:Int = readln().toIntOrNull() ?: -1
            if(valor in 0..10) valores[index] = valor
        }while (valor !in 0..10)
    }
    println("A média do aluno é ${valores.sum() / valores.size}")
}