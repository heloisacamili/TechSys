package br.com.senai.controller;

import java.util.List;

import br.com.senai.entity.PessoaEntity;
import br.com.senai.service.PessoaService;

public class PessoaEntityController {
	PessoaService pessoaService = new PessoaService();
	
	public PessoaEntity cadastrarPessoa(String nome, String cpf){
        return pessoaService.cadastrarPessoa(nome, cpf);
    }

    public void listarPessoas(List<PessoaEntity> pessoas){
        pessoaService.listarPessoas(pessoas);
    }

    public PessoaEntity editarPessoa(PessoaEntity pessoaEntity){
        return pessoaService.editarPessoa(pessoaEntity);
    }
}
