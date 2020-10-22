
package model;

public class AlunoDisciplina {
    private int Id;
    private int AlunoId;
    private int DisciplinaId;
    private float np1;
    private float np2;
    private float media;
    private int faltas;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAlunoId() {
        return AlunoId;
    }

    public void setAlunoId(int AlunoId) {
        this.AlunoId = AlunoId;
    }

    public int getDisciplinaId() {
        return DisciplinaId;
    }

    public void setDisciplinaId(int DisciplinaId) {
        this.DisciplinaId = DisciplinaId;
    }

    public float getNp1() {
        return np1;
    }

    public void setNp1(float np1) {
        this.np1 = np1;
    }

    public float getNp2() {
        return np2;
    }

    public void setNp2(float np2) {
        this.np2 = np2;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    
    
    
}
