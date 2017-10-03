package BLL;

import DTO.Conta;
import DTO.ContaPoupanca;
import DTO.Pessoa;

public class ContaPoupancaBLL implements ContaBLL {
       
    public ContaPoupanca criarContaPoupanca(String nome, int idade, String cpf, double saldo, double rendimento){
        return new ContaPoupanca(new Pessoa(nome, idade, cpf), saldo, rendimento);
    }

    @Override
    public void sacarDinheiro(Conta conta, double valor) {
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
    public void depositarDinheiro(Conta conta,double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Deposito realizado com sucesso! Saldo atual:" + conta.getSaldo());
    }
    
    public void aplicarRendimento(ContaPoupanca conta){
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * conta.getRendimento()));
        System.out.println("Redimento de " + conta.getRendimento() + " aplicado, valor do saldo: " + conta.getSaldo());
    }

    
    
}
