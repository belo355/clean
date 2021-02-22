package infra.aluno;

import dominio.aluno.Aluno;
import dominio.aluno.Cpf;
import dominio.aluno.NaoEncontrouAlunoException;
import dominio.aluno.RepositoryAlunos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAlunosMemoria implements RepositoryAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) throws SQLException {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno findByCPF(Cpf cpf) throws SQLException {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new NaoEncontrouAlunoException(cpf));
    }

    @Override
    public List<Aluno> alunosMatriculados() {
        return this.matriculados;
    }
}
