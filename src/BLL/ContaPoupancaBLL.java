package BLL;

import DTO.ContaPoupanca;

public class ContaPoupancaBLL implements ContaBLL {
    
    private ContaPoupanca conta;

    @Override
    public void sacarDinheiro(double valor) {
        if(conta.getCorrentista().getIdadeCorrentista() <= 18){
            System.out.println("Idade não permitida, consulte sua agência");
            return;
        }
        if(conta.getSaldo() < valor){
            System.out.println("Não é possivel sacar este valor! Limite inferior");
        } else{
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso. Saldo atual:" + conta.getSaldo());
        }
            
    }

    @Override
    public void depositarDinheiro(double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Deposito realizado com sucesso! Saldo atual:" + conta.getSaldo());
    }
    
    public void aplicarRendimento(){
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * conta.getRendimento()));
        System.out.println("Redimento de " + conta.getRendimento() + " aplicado, valor do saldo: " + conta.getSaldo());
    }
    
}
