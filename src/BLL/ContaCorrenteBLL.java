package BLL;

import DTO.Conta;
import DTO.ContaCorrente;
import DTO.Pessoa;

public class ContaCorrenteBLL implements ContaBLL {

    public ContaCorrente criarConta(String nome, int idade, String cpf,double saldoInicial, Boolean chequeEspecialAtivado){
        return new ContaCorrente(new Pessoa(nome, idade, cpf), saldoInicial,chequeEspecialAtivado);
    }
    
    @Override
    public void sacarDinheiro(Conta contaGen, double valor) {
        ContaCorrente conta = (ContaCorrente) contaGen;
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
    public void depositarDinheiro(Conta contaGen, double valor) {
        ContaCorrente conta = (ContaCorrente) contaGen; //gambiarra
        if(conta.getChequeEspecialAtivado()){
            conta.setChequeEspecial(conta.getChequeEspecial() + valor);
            System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getChequeEspecial());            
        } else{
            conta.setSaldo(conta.getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso, saldo disponivel: " + conta.getSaldo());            
        }

    }
    
}
