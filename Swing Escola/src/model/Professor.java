package model;

import java.util.Date;

public class Professor {
    private int Id;
    private String Nome;
    private String Endereco;
    private String TelefoneFixo;
    private String TelefoneCelular;
    private Date DataNascimento;
    private String Especialdade;
    private String Titulo;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefoneFixo() {
        return TelefoneFixo;
    }

    public void setTelefoneFixo(String TelefoneFixo) {
        this.TelefoneFixo = TelefoneFixo;
    }

    public String getTelefoneCelular() {
        return TelefoneCelular;
    }

    public void setTelefoneCelular(String TelefoneCelular) {
        this.TelefoneCelular = TelefoneCelular;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getEspecialdade() {
        return Especialdade;
    }

    public void setEspecialdade(String Especialdade) {
        this.Especialdade = Especialdade;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    
    
    
    
    
}
