class Curso(
        var nomeDoCurso: String,
        var codigoDoCurso: Int,
        var qtdMaxAlunos: Int,
        var professorAdjunto: ProfessorAdjunto? = null,
        var professorTitular: ProfessorTitular? = null,

        ) {
    var listaAlunosCurso: MutableList<Aluno> = mutableListOf()

    fun adicionarAluno(umAluno: Aluno): Boolean {


        when {
            listaAlunosCurso.contains(umAluno) -> {

                return false

            }
            listaAlunosCurso.size >= qtdMaxAlunos -> {
                println("Não há vagas!!")
                return false
            }
            else -> {
                listaAlunosCurso.add(umAluno)
                println("Aluno Matriculado com sucesso no curso ${nomeDoCurso}!!")
                return true
            }
        }
    }

    fun excluirAluno(umAluno: Aluno) {
        if (!listaAlunosCurso.contains(umAluno)) {
            println("Aluno inexistente!!")
        } else {
            listaAlunosCurso.remove(umAluno)
            println("Aluno Removido Com Sucesso!!")
        }


    }


}