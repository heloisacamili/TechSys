package br.com.senai.controller;

import java.time.LocalDate;
import java.util.List;

import br.com.senai.entity.ContaEntity;
import br.com.senai.service.ContaService;

public class ContaEntityController {
	ContaService contaService = new ContaService();
	
	public ContaEntity cadastrarConta(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta){
        return contaService.cadastrarConta(numConta, agencia, dataAbertura, saldoEmConta);
    }

    public ContaEntity cadastrarContaTipo(int numConta, int agencia, LocalDate dataAbertura, double saldoEmConta, int tipoConta){
        return contaService.cadastrarContaTipo(numConta, agencia, dataAbertura, saldoEmConta, tipoConta);
    }

    public void listarContas(List<ContaEntity> contas){
       contaService.listarContas(contas);
    }

    public ContaEntity editarConta(ContaEntity contaEntity){
        return contaService.editarConta(contaEntity);
    }
    
    public ContaEntity realizarTransacao(ContaEntity contaEntity) {
    	return contaService.realizarTransacao(contaEntity);
    }
}
