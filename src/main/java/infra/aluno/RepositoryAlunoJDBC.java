package infra.aluno;

import dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositoryAlunoJDBC implements RepositoryAlunos {

    private final Connection connection;

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
    public Aluno findByCPF(Cpf cpf) throws SQLException {
        Aluno findAluno = null;
        String sql = "SELECT * FROM ALUNO WHERE ALUNO.CPF = " + cpf;
        PreparedStatement ps = connection.prepareStatement(sql);
        try{
            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if(!encontrou){throw new NaoEncontrouAlunoException(cpf);
            }

            if(rs.next()){
                String cpfAluno = rs.getString(1);
                String nomeAluno = rs.getString(2);
                String emailAluno = rs.getString(3);

                findAluno.setCpf(cpf);
                findAluno.setNome(nomeAluno);
                findAluno.setEmail(emailAluno);

                return findAluno;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
        connection.close();
        return null;
    }

    @Override
    public List<Aluno> alunosMatriculados() {
        return null;
    }
}
