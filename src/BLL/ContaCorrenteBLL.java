package BLL;

import DTO.ContaCorrente;

public class ContaCorrenteBLL implements ContaBLL {

    private ContaCorrente conta;
    
    @Override
    public void sacarDinheiro(double valor) {
        
        if(conta.getSaldo() < valor){
            if(conta.getChequeEspecialAtivado()){
                if(conta.getSaldo() + conta.getLimiteChequeEspecial() < valor){
                    double aux = conta.getSaldo();
                    conta.setSaldo(conta.getSaldo() - aux); // saldo zerado
                    conta.setLimiteChequeEspecial(valor - aux);
                    System.out.println("Saque realizado com sucesso em cheque especial, saldo disponivel:" + conta.getSaldo() + conta.getLimiteChequeEspecial());                    
                } else{
                    System.out.println("Não é possivel sacar este valor, limite de cheque especial insuficiente:" + (conta.getSaldo() + conta.getLimiteChequeEspecial()));
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
            if(conta.getSaldo() == 0){
                double aux = conta.getLimiteChequeEspecial();
            } else{
                conta.setSaldo(conta.getSaldo() + valor);
                System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getSaldo());            
            }
        } else{
            conta.setSaldo(conta.getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getSaldo());            
        }

    }
    
}
