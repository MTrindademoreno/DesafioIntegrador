import java.time.LocalDateTime

class DigitalHouseManager {
    private var listaAlunos: MutableList<Aluno> = mutableListOf()
    private var listaProfessor: MutableList<Professor> = mutableListOf()
    private var listaCurso: MutableList<Curso> = mutableListOf()
    private var listaMatriculas: MutableList<Matricula> = mutableListOf()

    private lateinit var curso: Curso
    private lateinit var aluno: Aluno
    private lateinit var matricula: Matricula



    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaxAluno: Int) {
        val cursoAdd = Curso(nome, codigoCurso, qtdMaxAluno)
        if (listaCurso.firstOrNull { curso -> curso.codigoDoCurso == codigoCurso } == null) {
            listaCurso.add(cursoAdd)
            println("Curso $nome registrado com sucesso!!")
        } else {
            println("O Curso $nome já está registrado!!")
        }


    }

    fun excluirCurso(codigoCurso: Int) {
        val cursoRem = listaCurso.find { it.codigoDoCurso == codigoCurso }
        if (cursoRem != null) {
            listaCurso.remove(cursoRem)
            println("Curso ${cursoRem.nomeDoCurso} excluido com sucesso!!")
        } else {
            println("Curso não localizado!! ")
        }

    }




    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, qtdHorasMonitoria: Int) {
        val tempoDeCasa = 0



        val addProfessorA = ProfessorAdjunto(nome, sobrenome, tempoDeCasa, codigoProfessor, qtdHorasMonitoria)
        if (listaProfessor.any { addProfessorA == it }) {
            println("Professor ${addProfessorA.nome} ${addProfessorA.sobrenome} já está registrado!!")

        } else {
            listaProfessor.add(addProfessorA)

            println("Professor ${addProfessorA.nome} ${addProfessorA.sobrenome} registrado com sucesso!!")
        }

    }


    fun registrarProfessorTitular(nome: String, sobrenome: String, codigo: Int, especialidade: String) {
        val tempodecasa = 0
        val addProfessorTitular = ProfessorTitular(nome, sobrenome, tempodecasa, codigo, especialidade)

        if (listaProfessor.any { addProfessorTitular == it }) {
            println("Professor ${addProfessorTitular.nome} ${addProfessorTitular.sobrenome} já está registrado!!")
        } else {
            listaProfessor.add(addProfessorTitular)
            println("Professor ${addProfessorTitular.nome} ${addProfessorTitular.sobrenome} registrado com sucesso!!")
        }
    }

    fun excluirProfessor(codigo: Int) {

        if (listaProfessor.any { it.codigoProfessor == codigo }) {
            listaProfessor.removeIf { it.codigoProfessor == codigo }
            println("Professor Removido com sucesso!!")

        } else {
            println("Professor não localizado!!")
        }


    }

    fun matricularAluno(nome: String, sobrenome: String, codigodigoAluno: Int) {

        val alunoadd = Aluno(nome, sobrenome, codigodigoAluno)
        if (listaAlunos.any { it.nome == alunoadd.nome && it.sobrenome == alunoadd.sobrenome }) {
            println("Aluno ${alunoadd.nome} já existe!!")
        } else {
            listaAlunos.add(alunoadd)
            println("Aluno ${alunoadd.nome} adicionado com sucesso!!")
        }

    }

    fun matricularAluno(codigodigoAluno: Int, codigoCurso: Int) {


        listaAlunos.forEach {
            if (codigodigoAluno == it.codigoAluno) {
                aluno = it
            }
        }

        listaCurso.forEach {
            if (codigoCurso == it.codigoDoCurso) {
                curso = it

            }
        }



        try {
            curso.adicionarAluno(aluno)

            matricula = Matricula(aluno, curso, LocalDateTime.now())
            if (listaMatriculas.find { it == matricula } == null) {
                listaMatriculas.add(matricula)
            } else {
                println("O aluno  ${aluno.nome} já está matriculado no curso ${curso.nomeDoCurso}!!")
            }

        } catch (e: Exception) {
            println("Erro ao Realizar a matricula(Verifique os Dados)!!")
        }


    }

    fun alocarProfessor(codigoCurso: Int,codigoProfessorTitular: Int,codigoProfessorAdjunto: Int){

        val adjunto = listaProfessor.find { it.codigoProfessor==codigoProfessorAdjunto } ?:return println("Professor Adjunto não encontrado" )

        val titular = listaProfessor.find{it.codigoProfessor ==codigoProfessorTitular}?: return println("Professor Titular não encontarado")
        val curso = listaCurso.find { it.codigoDoCurso==codigoCurso } ?: return println( "Curso não encontrado")


            curso.professorAdjunto=adjunto as ProfessorAdjunto
            curso.professorTitular=titular as ProfessorTitular
            println("Professor(s) alocado(s) com sucesso!!")

    }




    fun mostramatricula() {
        println("--------------------Total e matriculas em cursos: ${listaMatriculas.count()}-------------")
        for (i in listaMatriculas) {
            println("Matricula ${listaMatriculas.indexOf(i)+1}")
            println("Aluno : ${i.aluno.nome}  ${i.aluno.sobrenome}")
            println("Curso: ${i.curso.nomeDoCurso}")
            println("Professor Titular: ${i.curso.professorTitular?.nome}")
            println("Professor Adjunto :${i.curso.professorAdjunto?.nome}")
            println("-------------------------------------------------------------")
        }
    }

    //teste
    fun listaAlunos() {
        for (i in listaAlunos) {
            println(i.nome)
        }
    }


    fun mostraProfessor() {
        println("------------------Alocação de Professores--------------------------------")
        listaProfessor.forEach {professor->
           var listaCursoP= listaCurso.filter { it.professorTitular?.nome ==professor.nome }
            var listaCursoP1= listaCurso.filter { it.professorAdjunto?.nome ==professor.nome }

            for (i in listaCursoP1){
                if (professor!=null){
                    println("Adjunto: Código:${professor.codigoProfessor}---- Nome:${professor.nome} ${professor.sobrenome} Curso : ${i.nomeDoCurso}")}



            }

            for (i in listaCursoP){
                if (professor!=null){
            println(" Titular :Código:${professor.codigoProfessor}---- Nome:${professor.nome} ${professor.sobrenome} Curso: ${i.nomeDoCurso}")}


            }

        }


    }



}