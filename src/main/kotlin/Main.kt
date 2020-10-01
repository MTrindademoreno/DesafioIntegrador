import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset.UTC
import kotlin.system.measureTimeMillis

fun main(){
    val aluno1 = Aluno("Aluno1","Sobrenome1",1)
    val aluno2 = Aluno("Aluno2", "Sobrenome2",2)
    val aluno3 =Aluno("Aluno3","Sobrenome3",3)
    val aluno4 = Aluno("Aluno4","sobrenome4",4)
    val curso = Curso("Android",100,2)

    val manager =DigitalHouseManager()

    println("---------------------Inserir aluno via classe Curso--------------")
    with(curso) {
        adicionarAluno(aluno1)
        adicionarAluno(aluno2)
        adicionarAluno(aluno1)
        adicionarAluno(aluno3)
        excluirAluno(aluno1)
        excluirAluno(aluno4)


    }
   with(manager){
       println("----------------------------Cursos-----------------------------------------------")
        registrarCurso("Android",100,3)
        registrarCurso("Java",200,1)
       registrarCurso("C",300,1)
       registrarCurso("C",300,1)
       registrarCurso("Kotlin",400,2)



println("-----------------------Registro de Professores-------------------------------")
        registrarProfessorAdjunto("Professor1","Sobrenomeprofessor1",1,1)
       registrarProfessorAdjunto("Professor2","sobrenomeprofessor2",2,12)
     registrarProfessorAdjunto("Professor3","sobrenomeprofessor3",3,123)
      registrarProfessorTitular("Professor4","sobrenomeprofessor4",4,"Spring")
       registrarProfessorTitular("Professor5","sobrenomeprofessor5",5,"Firebase")
       registrarProfessorTitular("Professor6","sobrenomeprofessor6",6,"MVVM")


       registrarProfessorAdjunto("Professor1","Sobrenomeprofessor1",1,1)//teste duplicidade


       mostraProfessor()


       println("---------------------Matricula na Instituição-------------------------")
        matricularAluno("marck","navarini",123)
        matricularAluno("luigi","navrini",124)
       matricularAluno("luigi","navrini",124)
       println("---------------------Matricula no Curso-------------------------")
     matricularAluno(121,200)
    matricularAluno(124,200)
       matricularAluno(123,100)
       matricularAluno(123,100)
       matricularAluno(124,200)
       println("----------------------Retorno de alocação--------------------------")
       alocarProfessor(100,5,1)
       alocarProfessor(200,6,2)
       alocarProfessor(300,4,3)


       mostramatricula()

       mostraProfessor()


















    }



}