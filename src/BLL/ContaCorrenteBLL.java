package BLL;

import DTO.ContaCorrente;

public class ContaCorrenteBLL implements ContaBLL {

    private ContaCorrente conta;
    
    @Override
    public void sacarDinheiro(double valor) {
        if(conta.getSaldo() < valor){
            System.out.println("Não é possivel sacar este valor! Saldo insuficiente:" + conta.getSaldo());
        } else{
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso, saldo disponivel:" + conta.getSaldo());
        }
    }

    @Override
    public void depositarDinheiro(double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Deposito realizado com sucesso, saldo disponivel: " +conta.getSaldo());
    }
    
}
