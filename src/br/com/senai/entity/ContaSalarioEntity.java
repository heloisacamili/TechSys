package br.com.senai.entity;

import java.time.LocalDate;

public class ContaSalarioEntity extends ContaEntity {
	private final double taxaManutencao = 15.0;
	private int numTransacoes;
	
	public ContaSalarioEntity() {
		this.numTransacoes = 0;
	}
	
	public ContaSalarioEntity(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta) {
		super(numConta, agencia, dataAbertura, saldoEmConta);
		this.numTransacoes = 0;
	}
	
	public void contador() {
		numTransacoes++;
	}
	
	public void aplicarTaxa() {
		if (numTransacoes > 2) {
			setSaldoEmConta(getSaldoEmConta() - taxaManutencao);
		}
	}

	public int getNumTransacoes() {
		return numTransacoes;
	}

	public void setNumTransacoes(int numTransacoes) {
		this.numTransacoes = numTransacoes;
	}

	public double getTaxaManutencao() {
		return taxaManutencao;
	}
}
