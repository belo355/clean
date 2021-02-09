package infra.aluno;

import dominio.aluno.Aluno;
import dominio.aluno.Cpf;
import dominio.aluno.RepositoryAlunos;
import dominio.aluno.Telefone;
import sun.plugin2.gluegen.runtime.CPU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositoryAlunoJDBC implements RepositoryAlunos {

    private Connection connection;

    public RepositoryAlunoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) throws SQLException {
        try {
            String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            //list telefones
            sql =" INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()){
                ps.setString(1, telefone.getDdd());
                ps.setString(1, telefone.getNumero());
                ps.execute();
            }
            ps.close();
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno findByCPF(Cpf cpf) {
        try{
            String sql = "SELECT * FROM ALUNO WHERE ALUNO.CPF = " + cpf;
            PreparedStatement ps = connection.prepareStatement(sql);
            //TODO: continuar daq o desenvolvimento do retorno de aluno
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aluno> alunosMatriculados() {
        return null;
    }
}
