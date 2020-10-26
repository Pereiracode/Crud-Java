
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Curso;
import model.Disciplina;

public class cursoDao {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Curso> lista = new ArrayList<Curso>();

    public cursoDao() {
        conn = new ConnectionFactory().getConexao();
    }
    
    public ArrayList<Disciplina> DisciplinaPorCurso(String curso) {
        String sql =
                "SELECT d.* " +
                "FROM curso c, cursodisciplina cd, disciplina d " +
                "WHERE c.nome = ? " +
                "AND d.id = cd.disciplinaid " +
                "AND c.id = cd.cursoid ";

        ArrayList<Disciplina> disciplinaList = new ArrayList();

        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso);
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
    
    
    public void inserir(Curso curso){
        String sql = "INSERT INTO CURSO (nome, tipo, carga_horaria) VALUES (?, ?, ?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getTipo());
            stmt.setInt(3, curso.getCargaHoraria());
            stmt.execute();
            stmt.close();
            
        }catch(Exception e){
            throw new RuntimeException("Erro 2: " + e);
        }
    }
    
    public void alterar(Curso curso){
        String sql = "UPDATE curso SET nome = ?, tipo = ?, carga_horaria = ? WHERE id = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getTipo());
            stmt.setInt(3, curso.getCargaHoraria());
            stmt.setInt(4, curso.getId());
            stmt.execute();
            stmt.close();

        }catch(Exception e){
            throw new RuntimeException("Erro 3: " + e);
        }
    }
    
    public void excluir(int valor){
        String sql = "DELETE FROM curso WHERE id = " + valor;
        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception e){
            throw new RuntimeException("Erro 4: " + e);
        }
    }
    
    public ArrayList<Curso> listarTodos(){
        String sql = "SELECT * FROM curso";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTipo(rs.getString("tipo"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));
                lista.add(curso);
            }
        }catch(Exception e){
            throw new RuntimeException("Erro 5: " + e);
        }
        return lista;
    }
}
