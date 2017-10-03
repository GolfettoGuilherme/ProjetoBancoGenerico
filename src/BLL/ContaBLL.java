package BLL;

import DTO.Conta;
import DTO.ContaPoupanca;

public interface ContaBLL {
    
    public abstract void sacarDinheiro(Conta conta, double valor);;
    public abstract void depositarDinheiro(Conta conta, double valor);
}
