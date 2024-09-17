package br.com.senai.entity;

import java.time.LocalDate;

public class ContaEntity {
	private int numConta;
	private int agencia;
	private LocalDate dataAbertura;
	private double saldoEmConta;
	
	public ContaEntity() {}
	
	public ContaEntity(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta) {
		this.numConta = numConta;
		this.agencia = agencia;
		this.dataAbertura = dataAbertura;
		this.saldoEmConta = saldoEmConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldoEmConta() {
		return saldoEmConta;
	}

	public void setSaldoEmConta(double saldoEmConta) {
		this.saldoEmConta = saldoEmConta;
	}
	
	public void depositar(double valor) {
		 double saldo = getSaldoEmConta();
		 if (getSaldoEmConta() > 0) {
			 setSaldoEmConta(saldo += valor);
		 } else {
			 System.out.println("Valor de deposito deve ser válido.");
		 }  
	 }
	 
	 public void sacar(double valor) {
		 double saldo = getSaldoEmConta();
		 if (valor > 0 && saldo >= valor) {
			 setSaldoEmConta(saldo -= valor);
		 } else {
			 System.out.println("Saldo insuficiente ou valor inválido.");
		 }
	 }
}
