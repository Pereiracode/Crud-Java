
package model;

public class CursoProfessor {
    private int Id;
    private int CursoId;
    private int ProfessorId;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int CursoId) {
        this.CursoId = CursoId;
    }

    public int getProfessorId() {
        return ProfessorId;
    }

    public void setProfessorId(int ProfessorId) {
        this.ProfessorId = ProfessorId;
    }
}
