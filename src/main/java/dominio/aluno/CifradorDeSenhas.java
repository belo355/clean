package dominio.aluno;

public interface CifradorDeSenhas {

    String cifrar(String senha);

    boolean validarSenhaCifrada(String cenhaCifrada, String senhaAberta);

}