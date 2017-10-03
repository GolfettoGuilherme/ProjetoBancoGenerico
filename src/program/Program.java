package program;

import BLL.*;
import DTO.*;
import java.io.IOException;
import java.util.Scanner;
        
public class Program {
    
    static Scanner leitor;
    public static void main(String[] args){
        int valorEscolhido;
        leitor = new Scanner(System.in);
        //criar conta corrent
        System.out.println("Bem vindo ao Banco Genérico");
        System.out.println("Aqui você pode criar sua conta");
        System.out.println("Depositar dinheiro");
        System.out.println("Sacar dinheiro");
        System.out.println("Obter lucro com rendimentos");
        System.out.println("Usar e abusar do Cheque Especial duplo");
        System.out.println("Digite o que deseja fazer:");
        System.out.println("* 1 - Abertura de Conta Corrente");
        System.out.println("* 2 - Abertura do Conta Poupança");
        System.out.println("* 0 - Encerrar Programa");
        valorEscolhido = leitor.nextInt();
        switch(valorEscolhido){
            case 1:
                try{
                    criarContaCorrente();
                } catch(Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                break;
            case 2:
                try{
                    criarContaPoupanca();    
                } catch(Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                break;
            case 0:
                System.exit(0);
        }
    }
    
    private static void criarContaPoupanca() throws IOException{     
        clearConsole();
        String nome, cpf;
        int idade, respostaUsuario;
        double saldo, rendimento = 0.15;
        leitor = new Scanner(System.in);
        System.out.println("Digite o nome do Correntista:");
        nome = leitor.nextLine();
        System.out.println("Digite a idade do Correntista:");
        idade = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Digite o CPF do Correntista:");
        cpf = leitor.nextLine();
        System.out.println("Digite o saldo inicial da conta:");
        saldo = leitor.nextDouble();
        ContaPoupancaBLL bll = new ContaPoupancaBLL();
        ContaPoupanca conta = bll.criarContaPoupanca(nome, idade, cpf, saldo, rendimento);
        for(;;){
            clearConsole();
            System.out.println("Conta do " + conta.getCorrentista().getNomeCorrentista());
            System.out.println("Digite o que deseja fazer:");
            System.out.println("* 1 - Depositar Dinheiro");
            System.out.println("* 2 - Sacar Dinheiro");
            System.out.println("* 3 - Conferir Saldo");
            System.out.println("* 4 - Aplicar Rendimento");
            System.out.println("* 0 - Encerrar");
            respostaUsuario = leitor.nextInt();
            
            if(respostaUsuario == 0){
                break;
            }
            
            switch(respostaUsuario){
                case 1:
                    double valor = 0.0;
                    System.out.println("Digite o quanto deseja Depositar:");
                    valor = leitor.nextDouble();
                    bll.depositarDinheiro(conta, valor);
                    esperarOkParaContinuar();
                    break;
                case 2:
                    System.out.println("Digite o valor do Saque:");
                    bll.sacarDinheiro(conta, leitor.nextDouble());
                    esperarOkParaContinuar();
                    break;
                case 3: 
                    System.out.println("Saldo disponivel:"+ conta.getSaldo());
                    System.out.println("Rendimento:" + conta.getRendimento());
                    esperarOkParaContinuar();
                    break;
                case 4: 
                    bll.aplicarRendimento(conta);
                    esperarOkParaContinuar();
                    break;
            }
        }
        
    }
    
    private static void criarContaCorrente() throws IOException{  
        clearConsole();
        String nome, cpf;
        int idade, respostaUsuario;
        Boolean chequeEspecial = false;
        double saldo;
        leitor = new Scanner(System.in);
        System.out.println("Digite o nome do Correntista:");
        nome = leitor.nextLine();
        System.out.println("Digite a idade do Correntista:");
        idade = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Digite o CPF do Correntista:");
        cpf = leitor.nextLine();
        System.out.println("Digite o saldo inicial da conta:");
        saldo = leitor.nextDouble();
        System.out.println("Deseja habilitar o cheque especial:");
        System.out.println("1 - SIM.");
        System.out.println("2 - NÃO");
        chequeEspecial = leitor.nextInt() == 1 ? true : false;
        
        ContaCorrenteBLL bll = new ContaCorrenteBLL();
        ContaCorrente conta = bll.criarConta(nome, idade, cpf, saldo,chequeEspecial);
        
        for(;;){
            clearConsole();
            System.out.println("Conta do " + conta.getCorrentista().getNomeCorrentista());
            System.out.println("Digite o que deseja fazer:");
            System.out.println("* 1 - Depositar Dinheiro");
            System.out.println("* 2 - Sacar Dinheiro");
            System.out.println("* 3 - Conferir Saldo");
            System.out.println("* 0 - Encerrar");
            respostaUsuario = leitor.nextInt();
            
            if(respostaUsuario == 0){
                break;
            }
            
            switch(respostaUsuario){
                case 1:
                    double valor = 0.0;
                    System.out.println("Digite o quanto deseja Depositar:");
                    valor = leitor.nextDouble();
                    bll.depositarDinheiro(conta, valor);
                    esperarOkParaContinuar();
                    break;
                case 2:
                    System.out.println("Digite o valor do Saque:");
                    bll.sacarDinheiro(conta, leitor.nextDouble());
                    esperarOkParaContinuar();
                    break;
                case 3: 
                    System.out.println("Saldo disponivel:"+ conta.getSaldo());
                    esperarOkParaContinuar();
                    break;
            }
        }
    }
 
    private static void esperarOkParaContinuar(){ 
        System.out.println("Aperte Enter para continuar...");
        try{
            System.in.read();
            clearConsole();
        }  
        catch(Exception e)
        {}  
    }

    public final static void clearConsole(){

        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        //  Tratar Exceptions
        }
    }
}
