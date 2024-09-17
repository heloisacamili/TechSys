package br.com.senai.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import br.com.senai.entity.ContaCorrenteEntity;
import br.com.senai.entity.ContaEntity;
import br.com.senai.entity.ContaPoupancaEntity;
import br.com.senai.entity.ContaSalarioEntity;

public class ContaService {
	Scanner sc = new Scanner(System.in);
	
	public ContaEntity cadastrarConta(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta){
        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setNumConta(numConta);
        contaEntity.setAgencia(agencia);
        contaEntity.setDataAbertura(dataAbertura);
        contaEntity.setSaldoEmConta(saldoEmConta);
        return contaEntity;
    }
	
	public ContaEntity cadastrarContaTipo(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta, int tipoConta){
		if (tipoConta == 1) {
			ContaCorrenteEntity contaEntity = new ContaCorrenteEntity();
	        contaEntity.setNumConta(numConta);
	        contaEntity.setAgencia(agencia);
	        contaEntity.setDataAbertura(dataAbertura);
	        contaEntity.setSaldoEmConta(saldoEmConta);
	        return contaEntity;
		} else if (tipoConta == 2) {
			ContaPoupancaEntity contaEntity = new ContaPoupancaEntity();
	        contaEntity.setNumConta(numConta);
	        contaEntity.setAgencia(agencia);
	        contaEntity.setDataAbertura(dataAbertura);
	        contaEntity.setSaldoEmConta(saldoEmConta);
	        return contaEntity;
		} else {
			ContaSalarioEntity contaEntity = new ContaSalarioEntity();
	        contaEntity.setNumConta(numConta);
	        contaEntity.setAgencia(agencia);
	        contaEntity.setDataAbertura(dataAbertura);
	        contaEntity.setSaldoEmConta(saldoEmConta);
	        return contaEntity;
		}
    }
	
	public ContaEntity editarConta(ContaEntity contaEntity){
		System.out.println("Informe o novo número da conta: ");
        int numConta = sc.nextInt();
        System.out.println("Informe a nova agencia: ");
        int agencia = sc.nextInt();
        System.out.println("Informe o novo saldo em conta: ");
        double saldo = sc.nextDouble();
        contaEntity.setNumConta(numConta);
        contaEntity.setAgencia(agencia);
        contaEntity.setSaldoEmConta(saldo);
        return contaEntity;
    }
	
	public void listarContas(List<ContaEntity> listaContas) {
		System.out.println("Contas cadastradas");
        listaContas.forEach(conta -> {
            System.out.println("Número da Conta: " + conta.getNumConta());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Data de abertura: " + conta.getDataAbertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.printf("Saldo em Conta: R$:%.2f\n", conta.getSaldoEmConta());
            System.out.println("------------------");
        });
	}
	
	public ContaEntity realizarTransacao(ContaEntity contaEntity) {
		System.out.println("Informe qual transação deseja fazer: \n1- Saque \n2- Depósito \n3- Verificar Saldo");
		int escolha = sc.nextInt();
		switch(escolha) {
			case 1 -> {
				System.out.println("--- SAQUE ----");
				System.out.print("Informe o valor a ser sacado: R$");
				double valor = sc.nextDouble();
				contaEntity.sacar(valor);
				System.out.printf("Seu saldo atual é: R$%.2f", contaEntity.getSaldoEmConta());
				return contaEntity;
			}
			case 2 -> {
				System.out.println("--- DEPOSITAR ----");
				System.out.println("Informe o valor a ser depositado: R$");
				double valor = sc.nextDouble();
				contaEntity.depositar(valor);
				System.out.printf("Seu saldo atual é: R$%.2f", contaEntity.getSaldoEmConta());
				return contaEntity;
			}
			case 3 -> {
				System.out.printf("Seu saldo atual é: R$%.2f", contaEntity.getSaldoEmConta());
				return contaEntity;
			}
			default -> {
				System.out.println("opção não disponivel.");
			}
		}
		return contaEntity;
	}
	
}
