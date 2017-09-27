package BLL;

import DTO.ContaCorrente;

public class ContaCorrenteBLL implements ContaBLL {

    private ContaCorrente conta;
    
    @Override
    public void sacarDinheiro(double valor) {
        if(conta.getSaldo() < valor){
            if(conta.getChequeEspecialAtivado()){
                if(conta.getChequeEspecial() < valor){
                   conta.setChequeEspecial(conta.getChequeEspecial() - valor);
                    System.out.println("Saque realizado com sucesso em cheque especial, saldo disponivel:" + conta.getChequeEspecial());                    
                } else{
                    System.out.println("Não é possivel sacar este valor, limite de cheque especial insuficiente:" + conta.getChequeEspecial());
                }
            } else{
                System.out.println("Não é possivel sacar este valor! Saldo insuficiente:" + conta.getSaldo());    
            }
        } else{
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso, saldo disponivel:" + conta.getSaldo());
        }
    }

    @Override
    public void depositarDinheiro(double valor) {
        if(conta.getChequeEspecialAtivado()){
            conta.setChequeEspecial(conta.getChequeEspecial() + valor);
            System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getChequeEspecial());            
        } else{
            conta.setSaldo(conta.getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getSaldo());            
        }

    }
    
}
