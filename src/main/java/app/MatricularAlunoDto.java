package app;

import dominio.aluno.Aluno;
import dominio.aluno.Cpf;
import dominio.aluno.Email;

public class MatricularAlunoDto {

        private String cpf ;
        private String nome;
        private String email;

        public Aluno criarAluno() {
                return new Aluno(new Cpf(cpf), nome, email);
        }

}
