package HoraDeCodar08.utils

fun pressEnterToContinue() {
    println("Pressione Enter para continuar...")
    readln()
    return
}

fun wait(action: String, timeToWait: Int) {
    print(action)
    for (i in 1..timeToWait) {
        print(".")
        Thread.sleep(1000)
    }
    println("")
}