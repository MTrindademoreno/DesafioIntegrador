import java.time.LocalDateTime
import java.util.*

open class Professor(
        nome: String,
        sobrenome: String,
        var tempoDeCasa: Int,
       var codigoProfessor: Int


):Pessoa(nome,sobrenome) {



    override fun equals(other: Any?): Boolean {
        return other?.let {
            val professor = (it as Professor)
            professor?.let {
                it.nome == nome && it.sobrenome == sobrenome && it.codigoProfessor == codigoProfessor
            } ?: false
        } ?: false

    }
}