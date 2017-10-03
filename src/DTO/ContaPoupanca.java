package DTO;

public class ContaPoupanca extends Conta{
    
    private double rendimento;
    
    public ContaPoupanca(Pessoa p, double saldo,double rendimento) {
        this.correntista = p;
        this.saldo = saldo;
        this.rendimento = rendimento;
    }
    

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
