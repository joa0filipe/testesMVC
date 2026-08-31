package View;
import Controller.BancoServicos;
import model.Conta;


import java.util.Map;
import java.util.Scanner;

public class viewBanco {
    private BancoServicos controller;
    private Scanner scanner;

    public viewBanco() {
        this.controller = new BancoServicos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 10;
        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuCadastrar();
                case 2 -> menuDeposito();
                case 3 -> menuSaque();
                case 4 -> menuSaldo();
                case 5 -> listaDeContas();
                case 0 -> System.out.println("Saindo");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    private void exibirMenu() {
        System.out.println("\n=== SISTEMA BANCÁRIO ===");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Consultar Saldo");
        System.out.println("5 - Contas cadastradas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    private void menuCadastrar() {


        System.out.print("Digite o ID da nova conta: ");
        int id = scanner.nextInt();
        if (controller.cadastro(id)) {
            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Erro: Conta já existente.");
        }
        System.out.println("pressione algum numero para voltar");
        int voltar = scanner.nextInt();
    }
    private void listaDeContas(){

        int qtd = 0;
        if (!controller.listarContas().isEmpty()){
            System.out.print("== CONTAS CADASTRADAS ==\n");
            for (Map.Entry<Integer, Conta> a : controller.listarContas().entrySet()){
                System.out.print("Conta : "+a.getKey()+"\nSaldo: "+a.getValue().getSaldo()+"\n\n");
                qtd += 1;
            }
            System.out.print("Total de contas :"+qtd);
        }else{
            System.out.print("Nenhuma Conta cadastrada\n");
        }
        System.out.println("pressione algum numero para voltar\n");
        int voltar = scanner.nextInt();
    }
    private void menuDeposito(){
        System.out.print("Digite o id da conta que deseja depositar : \n");
        int id = scanner.nextInt();
        Conta conta = controller.buscarConta(id);
        if(conta == null){
            System.out.println("Conta '"+id+"' não encontrada\n");
        }else{
            System.out.println("Conta encontrada\nSaldo atual de "+conta.getSaldo()+ " reais\nDigite o valor do deposito: ");
            int valor = scanner.nextInt();
            conta.depositar(valor);
            System.out.print("Deposito concluido\n");
        }
        System.out.println("pressione algum numero para voltar\n");
        int voltar = scanner.nextInt();
    }

    private void menuSaque(){
        System.out.print("Digite o id da conta que deseja sacar: \n");
        int id = scanner.nextInt();
        Conta conta = controller.buscarConta(id);
        if (conta == null) System.out.print("Conta nao encontrada\n");
        else {
            System.out.println("Conta encontrada\nSaldo atual de " + conta.getSaldo() + " reais\nDigite o valor do saque: ");
            float valor = scanner.nextInt();
            boolean a = controller.saque(id, valor);
            if (a) System.out.print("Saque efetuado\n");
            else System.out.print("Saldo insuficiente!\n");
        }
        System.out.println("pressione algum numero para voltar\n");
        int voltar = scanner.nextInt();
    }

    private void menuSaldo() {
        System.out.print("Digite o id da conta que deseja verificar: \n");
        int id = scanner.nextInt();
        Conta conta = controller.buscarConta(id);
        if (conta == null) System.out.print("Conta nao encontrada\n");
        else {
            System.out.println("Conta encontrada\nSaldo atual de " + conta.getSaldo() + " reais\n");
        }
        System.out.println("pressione algum numero para voltar\n");
        int voltar = scanner.nextInt();
    }
}
