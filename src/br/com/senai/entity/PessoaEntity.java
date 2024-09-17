package br.com.senai.entity;

public class PessoaEntity {
	private String nome;
	private String cpf;
	private ContaEntity conta;
	
	public PessoaEntity() {}
	
	public PessoaEntity(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public PessoaEntity(String nome, String cpf, ContaEntity conta) {
		this.nome = nome;
		this.cpf = cpf;
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ContaEntity getConta() {
		return conta;
	}

	public void setConta(ContaEntity conta) {
		this.conta = conta;
	}
}
