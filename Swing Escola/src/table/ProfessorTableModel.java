
package table;

import model.Professor;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProfessorTableModel extends AbstractTableModel {

    public static final int COL_CODIGO_PROF = 0;
    public static final int COL_NOME_PROF = 1;
    public static final int COL_ENDERECO_PROF = 2;
    public static final int COL_TELFIXO_PROF = 3;
    public static final int COL_TELCELULAR_PROF = 4;
    public static final int COL_DATANASCIMENTO_PROF = 5;
    public static final int COL_ESPECIALIDADE_PROF = 6;
    public static final int COL_TITULO_PROF = 7;
    
    
    public ArrayList<Professor> lista;

    public ProfessorTableModel(ArrayList<Professor> listaParametro) {
        lista = new ArrayList<Professor>(listaParametro);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Professor professor = lista.get(linhas);
        
        if(colunas == COL_CODIGO_PROF) return professor.getId();
        if(colunas == COL_NOME_PROF) return professor.getNome();
        if(colunas == COL_ENDERECO_PROF) return professor.getEndereco();
        if(colunas == COL_TELFIXO_PROF) return professor.getTelefoneFixo();
        if(colunas == COL_TELCELULAR_PROF) return professor.getTelefoneCelular();
        if(colunas == COL_DATANASCIMENTO_PROF) return professor.getDataNascimento();
        if(colunas == COL_ESPECIALIDADE_PROF) return professor.getEspecialidade();
        if(colunas == COL_TITULO_PROF) return professor.getTitulo();
        return "";
        
    }

    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CODIGO_PROF) return "Cógigo";
        if(colunas == COL_NOME_PROF) return "Professor";
        if(colunas == COL_ENDERECO_PROF) return "Endereço";
        if(colunas == COL_TELFIXO_PROF) return "Tel. Fixo";
        if(colunas == COL_TELCELULAR_PROF) return "Celular";
        if(colunas == COL_DATANASCIMENTO_PROF) return "Data de Nascimento";
        if(colunas == COL_ESPECIALIDADE_PROF) return "Especialidade";
        if(colunas == COL_TITULO_PROF) return "Título";
        return "";
    }
    
}
