import java.time.LocalDateTime

class Matricula(aluno: Aluno, curso: Curso, var data: LocalDateTime) {
    var aluno = aluno
    var curso = curso
    override fun equals(other: Any?): Boolean {
        return other?.let {
            val matricula = (it as Matricula)
            matricula?.let {
                it.aluno == aluno && it.curso ==curso
            } ?: false
        } ?: false

    }


}