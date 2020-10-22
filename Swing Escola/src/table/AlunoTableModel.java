
package table;

import model.Aluno;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AlunoTableModel extends AbstractTableModel {

    public static final int COL_CODIGO_ALUNO = 0;
    public static final int COL_NOME_ALUNO = 1;
    public static final int COL_DATANASCIMENTO_ALUNO = 2;
    public ArrayList<Aluno> lista;

    public AlunoTableModel(ArrayList<Aluno> listaParametro) {
        lista = new ArrayList<Aluno>(listaParametro);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Aluno aluno = lista.get(linhas);
        
        if(colunas == COL_CODIGO_ALUNO) return aluno.getId();
        if(colunas == COL_NOME_ALUNO) return aluno.getNome();
        if(colunas == COL_DATANASCIMENTO_ALUNO) return aluno.getDataNascimento();
        return "";
        
    }

    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CODIGO_ALUNO) return "Código";
        if(colunas == COL_NOME_ALUNO) return "Nome";
        if(colunas == COL_DATANASCIMENTO_ALUNO) return "Data de Nascimento";
        return "";
    }
    
}
