
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.Disciplina;

public class alunoDao {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Aluno> lista = new ArrayList<Aluno>();

    public alunoDao() {
        conn = new ConnectionFactory().getConexao();
    }

    public ArrayList<Disciplina> DisciplinaPorAluno(String aluno) {
        String sql =
                "SELECT d.* " +
                "FROM aluno a, alunodisciplina ad, disciplina d " +
                "WHERE a.nome = ? " +
                "AND d.id = ad.disciplinaid " +
                "AND a.id = ad.alunoid ";

        ArrayList<Disciplina> disciplinaList = new ArrayList();

        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCargaHoraria(rs.getInt("carga_horaria"));
                disciplina.setAulasSemana(rs.getInt("aulas_semana"));

                disciplinaList.add(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinaList;
    }

    
    public void inserir(Aluno aluno){
        String sql = "INSERT INTO ALUNO (nome, data_nascimento) VALUES (?, ?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getDataNascimento());
            stmt.execute();
            stmt.close();
            
        }catch(Exception e){
            throw new RuntimeException("Erro 2: " + e);
        }
    }
    
    public void alterar(Aluno aluno){
        String sql = "UPDATE aluno SET nome = ?, data_nascimento = ? WHERE id = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getDataNascimento());
            stmt.setInt(3, aluno.getId());
            stmt.execute();
            stmt.close();

        }catch(Exception e){
            throw new RuntimeException("Erro 3: " + e);
        }
    }
    
    public void excluir(int valor){
        String sql = "DELETE FROM aluno WHERE id = " + valor;
        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception e){
            throw new RuntimeException("Erro 4: " + e);
        }
    }
    
    public ArrayList<Aluno> listarTodos(){
        String sql = "SELECT * FROM aluno";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNascimento(rs.getDate("data_nascimento").toString());
                lista.add(aluno);
            }
        }catch(Exception e){
            throw new RuntimeException("Erro 5: " + e);
        }
        return lista;
    }
}
