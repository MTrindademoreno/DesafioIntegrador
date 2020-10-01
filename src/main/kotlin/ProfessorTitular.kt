import java.time.LocalDateTime
import java.util.*

class ProfessorTitular(
        nome: String,
        sobrenome: String,
        tempoDeCasa: Int,
        codigoProfessor: Int,
        var especialidade:String

):Professor(nome,sobrenome,tempoDeCasa,codigoProfessor) {

}