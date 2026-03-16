package HoraDeCodar08.AbstractClasses

import HoraDeCodar08.Utils.enter

abstract class AnimalDeEstimacao {
    abstract val especie: String
    abstract val nome: String
    private var idade: Int = 0
    private var nivelDeFome: Int = 50
    private var nivelDeFelicidade: Int = 50
    private var nivelDeAfinidade: Int = 0
    private var nivelDeCansaco: Int = 0
    private var nivelDeTreinamento: Int = 0


    fun alimentar(alimento: Map<String, Int>) {
        println("Você alimentou ${this.nome} com ${alimento.keys.first()}")
        reduzirFome(alimento)
        aumentarCansaco()
        aumentarFelicidade()
        enter()
        return
    }

    fun brincar(tempo: Int) {
        println("Você brincou com ${this.nome} durante $tempo horas")
        aumentarFelicidade(tempo)
        aumentarCansaco(tempo)
        aumentarFome(tempo)
        aumentarAfinidade(tempo)
        enter()
        return
    }

    fun dormir(tempo: Int) {
        println("${this.nome} dormiu por $tempo horas")
        reduzirCansaco(tempo)
        aumentarFome(tempo)
        enter()
        return
    }

    fun verificarStatus() {
        println("INFORMAÇÕES ATUAIS DO PET")
        println("Espécie: ${this.especie}")
        println("Nome: ${this.nome}")
        println("Nível de Fome: ${this.nivelDeFome}")
        println("Nível de Felicidade: ${this.nivelDeFelicidade}")
        println("Nível de Afinidade: ${this.nivelDeAfinidade}")
        println("Nível de Cansaço: ${this.nivelDeCansaco}")
        println("Nível de Treinamento: ${this.nivelDeTreinamento}")
        enter()
        return
    }

    fun aniversario(){
        aumentarIdade()
        println("Hoje é o aniversário de ${this.nome}!")
        println("${this.nome} agora tem ${this.idade} anos.")
        enter()
    }

    private fun aumentarIdade() = idade++

    private fun aumentarFome(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeFome += pontosAlterados
        println("A fome de ${this.nome} aumentou em $pontosAlterados pontos")
        return
    }

    private fun reduzirFome(alimento: Map<String, Int>) {
        val pontosAlterados = alimento.values.first()
        this.nivelDeFome -= pontosAlterados
        println("A fome de ${this.nome} reduziu em $pontosAlterados pontos")
        return
    }

    private fun aumentarFelicidade(tempo: Int = 1) {
        val pontosAlterados = tempo * 5
        this.nivelDeFelicidade += pontosAlterados
        println("A felicidade de ${this.nome} aumentou em $pontosAlterados pontos")
        return
    }

    private fun reduzirFelicidade(tempo: Int = 1) {
        val pontosAlterados = tempo * 5
        this.nivelDeFelicidade -= pontosAlterados
        println("A felicidade de ${this.nome} reduziu em $pontosAlterados pontos")
        return
    }

    private fun aumentarCansaco(tempo: Int = 1) {
        val pontosAlterados = tempo * 5
        this.nivelDeCansaco += pontosAlterados
        println("O cansaço de ${this.nome} aumentou em $pontosAlterados pontos")
        return
    }

    private fun reduzirCansaco(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeCansaco += pontosAlterados
        println("O cansaço de ${this.nome} reduziu em $pontosAlterados pontos")
        return
    }

    private fun aumentarAfinidade(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeAfinidade += pontosAlterados
        println("A afinidade de ${this.nome} aumentou em $pontosAlterados pontos")
        return
    }

    private fun reduzirAfinidade(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeAfinidade -= pontosAlterados
        println("A afinidade de ${this.nome} reduziu em $pontosAlterados pontos")
        return
    }

    private fun aumentarTreinamento(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeTreinamento += pontosAlterados
        println("O treinamento de ${this.nome} aumentou em $pontosAlterados pontos")
        return
    }

    private fun reduzirTreinamento(tempo: Int) {
        val pontosAlterados = tempo * 5
        this.nivelDeTreinamento -= pontosAlterados
        println("O treinamento de ${this.nome} reduziu em $pontosAlterados pontos")
        return
    }

}