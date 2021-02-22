package dominio.aluno;

public class NaoEncontrouAlunoException extends RuntimeException {

    public NaoEncontrouAlunoException(Cpf cpf) {
        super("Aluno nao encontrado com CPF: "+ cpf.getNumero());
    }
}
