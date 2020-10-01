import java.time.LocalDateTime
import java.util.*

class ProfessorAdjunto(
        nome: String,
        sobrenome: String,
        tempoDeCasa: Int,
        codigoProfessor: Int,
       var qtdHorasMonitoria: Int

):Professor(nome,sobrenome,tempoDeCasa,codigoProfessor) {

}