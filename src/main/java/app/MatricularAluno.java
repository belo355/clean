package app;

import dominio.aluno.Aluno;
import dominio.aluno.RepositoryAlunos;

import java.sql.SQLException;

public class MatricularAluno {

    private final RepositoryAlunos repositoryAlunos;

    public MatricularAluno(RepositoryAlunos repositoryAlunos) {
        this.repositoryAlunos = repositoryAlunos;
    }

    public void matricular(MatricularAlunoDto dados) throws SQLException {
        Aluno novo = dados.criarAluno();
        repositoryAlunos.matricular(novo);
    }
}
