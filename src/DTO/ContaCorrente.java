package DTO;

public class ContaCorrente extends Conta {
    
    private Boolean chequeEspecialAtivo;
    private double chequeEspecial;
       
    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double limiteChequeEspecial) {
        this.chequeEspecial = limiteChequeEspecial;
    }

    public ContaCorrente(Pessoa p, double saldo, Boolean chequeEspecialAtivo){
        this.correntista = p;
        this.saldo = saldo;
        this.chequeEspecialAtivo = chequeEspecialAtivo;
        this.chequeEspecial = saldo * 2;
    }
    
    public Boolean getChequeEspecialAtivado() {
        return chequeEspecialAtivo;
    }

    public void setChequeEspecialAtivado(Boolean chequeEspecialAtivado) {
        this.chequeEspecialAtivo = chequeEspecialAtivado;
    }
    
}
