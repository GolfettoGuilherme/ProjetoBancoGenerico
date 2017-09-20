package DTO;

public class ContaCorrente extends Conta {
    
    private Boolean chequeEspecialAtivo;

    public ContaCorrente(Pessoa p, double saldo, Boolean chequeEspecialAtivo){
        this.correntista = p;
        this.saldo = saldo;
        this.chequeEspecialAtivo = chequeEspecialAtivo;
    }
    
    public Boolean getChequeEspecialAtivado() {
        return chequeEspecialAtivo;
    }

    public void setChequeEspecialAtivado(Boolean chequeEspecialAtivado) {
        this.chequeEspecialAtivo = chequeEspecialAtivado;
    }
        
}
