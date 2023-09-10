enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}
data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)
data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    val julia = Usuario("Júlia", 19)
    val andrey = Usuario("Andrey", 24)
    val osmar = Usuario("Osmar", 32)
    val bruna = Usuario("Bruna", 22)

    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução ao Desenvolvimento de Software"),
        ConteudoEducacional("Conceitos básicos de Kotlin"),
        ConteudoEducacional("Orientação a Objetos em Kotlin- POO"),
    	ConteudoEducacional("Classes e Herança em Kotlin"))


    val mobileAndroid = Formacao("Bootcamp Mobile com Kotlin", listaConteudosKotlin, Nivel.BASICO)

    mobileAndroid.let{
        mobileAndroid.matricular(andrey, osmar, bruna, julia)
    }
    
    println("${mobileAndroid.nome}")
    println("\tConteúdos:")
    mobileAndroid.mostrarConteudos()
    println("\tInscritos:")
    mobileAndroid.mostrarInscritos()
}