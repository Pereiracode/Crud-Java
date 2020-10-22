
package table;

import model.Disciplina;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DisciplinaTableModel extends AbstractTableModel {

    public static final int COL_CODIGO_DISCIPLINA = 0;
    public static final int COL_NOME_DISCIPLINA = 1;
    public static final int COL_CARGAHORARIA_DISCIPLINA = 2;
    public static final int COL_AULASSEMANA_DISCIPLINA = 3;
    public ArrayList<Disciplina> lista;

    public DisciplinaTableModel(ArrayList<Disciplina> listaParametro) {
        lista = new ArrayList<Disciplina>(listaParametro);
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
        Disciplina disciplina = lista.get(linhas);
        
        if(colunas == COL_CODIGO_DISCIPLINA) return disciplina.getId();
        if(colunas == COL_NOME_DISCIPLINA) return disciplina.getNome();
        if(colunas == COL_CARGAHORARIA_DISCIPLINA) return disciplina.getCargaHoraria();
        if(colunas == COL_AULASSEMANA_DISCIPLINA) return disciplina.getAulasSemana();
        return "";
        
    }

    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CODIGO_DISCIPLINA) return "Código";
        if(colunas == COL_NOME_DISCIPLINA) return "Disciplina";
        if(colunas == COL_CARGAHORARIA_DISCIPLINA) return "Carga Horária";
        if(colunas == COL_AULASSEMANA_DISCIPLINA) return "Aulas por semana";
        return "";
    }
    
}
