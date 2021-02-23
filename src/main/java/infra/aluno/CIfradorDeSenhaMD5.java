package infra.aluno;

import dominio.aluno.CifradorDeSenhas;

public class CIfradorDeSenhaMD5 implements CifradorDeSenhas {
    @Override
     public String cifrar(String senha) {
        return senha + "c0c649c4-7585-11eb-9439-0242ac130002";
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senhaAberta) {
        return senhaCifrada.equals(cifrar(senhaAberta));
    }
}
