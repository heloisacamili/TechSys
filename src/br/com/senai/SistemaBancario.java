package br.com.senai;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.controller.ContaEntityController;
import br.com.senai.controller.PessoaEntityController;
import br.com.senai.entity.ContaEntity;
import br.com.senai.entity.PessoaEntity;

public class SistemaBancario {
	static List<ContaEntity> listaDeContas = new ArrayList<>();
    static List<PessoaEntity> listaDePessoas = new ArrayList<>();
    static PessoaEntityController pessoaController = new PessoaEntityController();
    static ContaEntityController contaController = new ContaEntityController();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		boolean repetir = true;
		do {
			System.out.println("--- MENU ---");
			System.out.println("1 - Cadastrar conta");
			System.out.println("2 - Listar contas");
			System.out.println("3 - Editar conta");
			System.out.println("4 - Realizar transação em conta");
			System.out.println("5 - Atribuir conta a pessoa");
			System.out.println("6 - Cadastrar Pessoa");
			System.out.println("7 - Listar Pessoas");
			System.out.println("8 - Editar Pessoas");
			System.out.println("9 - Encerrar sistema.");
			int opcao = sc.nextInt();
			switch (opcao) {
				case 1 -> {
					cadastrarConta();
				}
				case 2 -> {
					listarContas();
				}
				case 3 -> {
					editarConta();
				}
				case 4 -> {
					realizarTransacao();
				}
				case 5 -> {
					//associarPessoa();
					System.out.println("no time!");
				}
				case 6 -> {
					cadastrarPessoa();
				}
				case 7 -> {
					listarPessoas();
				}
				case 8 -> {
					
				}
				case 9 -> {
					repetir = false;
					System.out.println("Sistema encerrado.");
					System.exit(0);
				}
				default -> {
					System.out.println("Opção indisponível, tente novamente.");
				}
			}
		} while (repetir);
	}
	
	public static void cadastrarConta() {
		System.out.println("--- CADASTRAR CONTA ---");
		System.out.println("Informe o tipo de conta desejada: \n1 - Corrente \n2 - Poupança \n3 - Salário");
        int tipoConta = sc.nextInt();
        System.out.print("Número da Conta: ");
        int numConta = sc.nextInt();
        System.out.print("Agência: ");
        int agencia = sc.nextInt();
        LocalDate dataAbertura = LocalDate.now();
        System.out.print("Saldo Inicial: R$");
        double saldo = sc.nextDouble();
        sc.nextLine();
        ContaEntity conta = contaController.cadastrarContaTipo(numConta, agencia, dataAbertura, saldo, tipoConta);
		listaDeContas.add(conta);
	}
	
	public static void cadastrarPessoa() {
		System.out.println("--- CADASTRAR CONTA ---");
		System.out.println("Informe o nome:");
		String nome = sc.nextLine();
        System.out.print("Número da CPF: ");
        String cpf = sc.nextLine();
        sc.nextLine();
        PessoaEntity pessoa = pessoaController.cadastrarPessoa(nome, cpf);
        listaDePessoas.add(pessoa);
	}
	
	public static void listarPessoas() {
		System.out.println("--- LISTAR PESSOAS ---");
		pessoaController.listarPessoas(listaDePessoas);
	}
	
	public static void editarPessoas() {
		System.out.println("--- EDITAR PESSOA ---");
		System.out.println("Informe o ID da pessoa: ");
		int id = sc.nextInt();
        if (id >= listaDePessoas.size() || id < 0){
            System.out.println("Pessoa não cadastrada!");
        }

        PessoaEntity pessoaEntityEdit = listaDePessoas.get(id);
        PessoaEntity pessoaEditada = pessoaController.editarPessoa(pessoaEntityEdit);
        listaDePessoas.set(id, pessoaEditada);
	}
	
	public static void listarContas() {
		System.out.println("--- LISTAR CONTAS ---");
		contaController.listarContas(listaDeContas);
	}
	
	public static void editarConta() {
		System.out.println("--- EDITAR CONTA ---");
		System.out.println("Informe o ID da conta: ");
		int id = sc.nextInt();
        if (id >= listaDeContas.size() || id < 0){
            System.out.println("Conta não cadastrada!");
        }

        ContaEntity contaEntityEdit = listaDeContas.get(id);
        ContaEntity contaEditada = contaController.editarConta(contaEntityEdit);
        listaDeContas.set(id, contaEditada);
	}
	
	public static void realizarTransacao() {
		System.out.println("--- REALIZAR TRANSAÇÃO ---");
		System.out.println("Informe o ID da conta: ");
		int id = sc.nextInt();
		if (id >= listaDeContas.size() || id < 0){
            System.out.println("Conta não cadastrada!");
        }
		ContaEntity transacao = listaDeContas.get(id);
		ContaEntity transacaoEscolhida = contaController.realizarTransacao(transacao);
		System.out.println(transacaoEscolhida);
	}

}
