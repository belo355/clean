package dominio.aluno;

public class BuilderAluno {

    private Aluno aluno;

    public BuilderAluno comNomeCPFEmail(String nome, String cpf, String email){
        this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return this;
    }

    public BuilderAluno comTelefone(String ddd, String numero) {
        this.aluno.addTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }
}
