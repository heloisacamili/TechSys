package br.com.senai.entity;

import java.time.LocalDate;

public class ContaPoupancaEntity extends ContaEntity {
	private final double rendimento = 0.15;
	
	public ContaPoupancaEntity() {} 
	
	public ContaPoupancaEntity(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta) {
		super(numConta, agencia, dataAbertura, saldoEmConta);
	}
	
	public void aplicaRendimento() {
		double rendimentoConta = getSaldoEmConta() * rendimento;
		setSaldoEmConta(getSaldoEmConta() + rendimentoConta);
	}
}
