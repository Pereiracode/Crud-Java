
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Professor;

public class professorDao {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Professor> lista = new ArrayList<Professor>();

    public professorDao() {
        conn = new ConnectionFactory().getConexao();
    }
    
    /*public void inserir(Disciplina disciplina){
        String sql = "INSERT INTO DISCIPLINA (nome, carga_horaria, aulas_semana) VALUES (?, ?, ?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getAulasSemana());
            stmt.execute();
            stmt.close();
            
        }catch(Exception e){
            throw new RuntimeException("Erro 2: " + e);
        }
    }
    
    public void alterar(Disciplina disciplina){
        String sql = "UPDATE disciplina SET nome = ?, carga_horaria = ?, aulas_semana = ? WHERE id = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getAulasSemana());
            stmt.setInt(4, disciplina.getId());
            stmt.execute();
            stmt.close();

        }catch(Exception e){
            throw new RuntimeException("Erro 3: " + e);
        }
    }
    
    public void excluir(int valor){
        String sql = "DELETE FROM disciplina WHERE id = " + valor;
        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception e){
            throw new RuntimeException("Erro 4: " + e);
        }
    }*/
    
    public ArrayList<Professor> listarTodos(){
        String sql = "SELECT * FROM professor";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setTelefoneFixo(rs.getString("telefone_fixo"));
                professor.setTelefoneCelular(rs.getString("telefone_celular"));
                professor.setDataNascimento(rs.getDate("data_nascimento"));
                professor.setEspecialidade(rs.getString("especialidade"));
                professor.setTitulo(rs.getString("titulo"));
                
                lista.add(professor);
            }
        }catch(Exception e){
            throw new RuntimeException("Erro 5: " + e);
        }
        return lista;
    }
}
