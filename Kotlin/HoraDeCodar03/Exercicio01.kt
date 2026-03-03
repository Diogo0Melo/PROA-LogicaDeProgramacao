package HoraDeCodar03

fun main(){
    /*
    Crie uma bomba relógio (usando somente código - para deixar claro!) cuja contagem regressiva vá de 30 a 0. No final da repetição escreva "EXPLOSÃO".
     */
    println("A Bomba foi ativada e explodirá em 35s")
    Thread.sleep(5000)
    for (i in 30 downTo 0){
        println("$i segundos para a explosão!!!")
        if(i==0)break
        Thread.sleep(1000)
    }
    println("EXPLOSÃO")
}