package dominio.aluno;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryAlunos {

    void matricular(Aluno aluno) throws SQLException;

    Aluno findByCPF(Cpf cpf);

    List<Aluno> alunosMatriculados();

}
