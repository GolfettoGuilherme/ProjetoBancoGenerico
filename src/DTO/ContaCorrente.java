package DTO;

public class ContaCorrente extends Conta {
    
    private Boolean chequeEspecialAtivo;
    private double limiteChequeEspecial;
    public static double LIMITE_CHEQUE_ESPECIAL_MAXIMO;
       
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public ContaCorrente(Pessoa p, double saldo, Boolean chequeEspecialAtivo){
        this.correntista = p;
        this.saldo = saldo;
        this.chequeEspecialAtivo = chequeEspecialAtivo;
        this.limiteChequeEspecial = saldo * 2;
        this.LIMITE_CHEQUE_ESPECIAL_MAXIMO = this.limiteChequeEspecial;
    }
    
    public Boolean getChequeEspecialAtivado() {
        return chequeEspecialAtivo;
    }

    public void setChequeEspecialAtivado(Boolean chequeEspecialAtivado) {
        this.chequeEspecialAtivo = chequeEspecialAtivado;
    }
    
}
