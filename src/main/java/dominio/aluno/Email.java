package dominio.aluno;

public class Email {
    private String endereco;

    public Email(String endereco){
        if(endereco == null || !endereco.contains("@")){
            throw new IllegalArgumentException("email inserido é invalido");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
