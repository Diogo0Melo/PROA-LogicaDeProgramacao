package HoraDeCodar03

fun main(){
    /*
    Faça um algoritmo que calcule e escreva a média aritmética dos números inteiros entre 15 (inclusive) e 100 (inclusive).
     */

    //forma 1 de fazer, foi a que eu pensei primeiro
    var resultado: Double = 0.0
    var divisor:Int = 0
    for (i in 15..100){
        resultado += i
        divisor++
    }
    println("Resultado da média: ${resultado/divisor}")

    //forma 2 de fazer, a que eu pensei assim que acabei a primeira e mais uns minutos de pensamentos profundos :)
    val valores = DoubleArray(86)
    valores.forEachIndexed { index, d ->
        valores[index] = (index+15).toDouble()
    }
    println("Resultado da média: ${valores.sum()/divisor}")

}


