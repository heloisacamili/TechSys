package br.com.senai.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import br.com.senai.entity.ContaEntity;
import br.com.senai.entity.PessoaEntity;

public class PessoaService {
	Scanner sc = new Scanner(System.in);
	
	public PessoaEntity cadastrarPessoa(String nome, String cpf) {
		PessoaEntity pessoaEntity = new PessoaEntity();
		pessoaEntity.setNome(nome);
        pessoaEntity.setCpf(cpf);
        return pessoaEntity;
	}
	
	public PessoaEntity cadastrarPessoaConta(String nome, String cpf, ContaEntity conta) {
		PessoaEntity pessoaEntity = new PessoaEntity();
		pessoaEntity.setNome(nome);
        pessoaEntity.setCpf(cpf);
        pessoaEntity.setConta(conta);
        return pessoaEntity;
	}
	
	public void listarPessoas(List<PessoaEntity> pessoas) {
		System.out.println("Pessoas cadastradas");
        pessoas.forEach(pessoa -> {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Conta atrelada: " + pessoa.getConta().toString());
            System.out.println("------------------");
        });
	}
	
	public PessoaEntity editarPessoa(PessoaEntity pessoaEntity){
		System.out.println("Informe o novo nome: ");
		String nome = sc.nextLine();
        System.out.println("Informe a novo cpf: ");
        String cpf = sc.nextLine();
        pessoaEntity.setNome(nome);
        pessoaEntity.setCpf(cpf);
        return pessoaEntity;
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
}
