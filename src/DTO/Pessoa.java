package DTO;

public class Pessoa {
    
    private String nomeCorrentista;
    private int idadeCorrentista;
    private String cpf;
    
    public Pessoa(String nomeCorrentista, int idadeCorrentista, String cpf) {
        this.nomeCorrentista = nomeCorrentista;
        this.idadeCorrentista = idadeCorrentista;
        this.cpf = cpf;
    }
    

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public int getIdadeCorrentista() {
        return idadeCorrentista;
    }

    public void setIdadeCorrentista(int idadeCorrentista) {
        this.idadeCorrentista = idadeCorrentista;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
