package infra.aluno.indicacao;

import dominio.aluno.EnviarEmailIndicacao;
import dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
     //logica de enviar email aqui
    }
}
