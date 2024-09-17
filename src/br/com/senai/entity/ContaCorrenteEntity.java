package br.com.senai.entity;

import java.time.LocalDate;

public class ContaCorrenteEntity extends ContaEntity {
	private final double taxaManutencao = 30.0;
	
	public ContaCorrenteEntity() {}
	
	public ContaCorrenteEntity(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta) {
		super(numConta, agencia, dataAbertura, saldoEmConta);
	}

	public double getTaxaManutencao() {
		return taxaManutencao;
	}
	
	public void aplicarTaxa() {
		setSaldoEmConta(getSaldoEmConta() - taxaManutencao);
	}
}
