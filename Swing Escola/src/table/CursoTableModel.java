
package table;

import model.Curso;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CursoTableModel extends AbstractTableModel {

    public static final int COL_CODIGO_CURSO = 0;
    public static final int COL_NOME_CURSO = 1;
    public static final int COL_TIPO_CURSO = 2;
    public static final int COL_CARGAHORARIA_CURSO = 3;
    public ArrayList<Curso> lista;

    public CursoTableModel(ArrayList<Curso> listaParametro) {
        lista = new ArrayList<Curso>(listaParametro);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Curso curso = lista.get(linhas);
        
        if(colunas == COL_CODIGO_CURSO) return curso.getId();
        if(colunas == COL_NOME_CURSO) return curso.getNome();
        if(colunas == COL_TIPO_CURSO) return curso.getTipo();
        if(colunas == COL_CARGAHORARIA_CURSO) return curso.getCargaHoraria();
        return "";
        
    }

    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CODIGO_CURSO) return "Código";
        if(colunas == COL_NOME_CURSO) return "Curso";
        if(colunas == COL_TIPO_CURSO) return "Tipo";
        if(colunas == COL_CARGAHORARIA_CURSO) return "Carga Horária";
        return "";
    }
    
}
