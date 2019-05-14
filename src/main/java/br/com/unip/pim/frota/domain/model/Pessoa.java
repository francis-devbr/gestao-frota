package br.com.unip.pim.frota.domain.model;

import lombok.Data;

@Data
public class Pessoa {

	private Long id;
	
	private String nome;
	
	private String cpfCnpj;
	
	private Endereco endereco;
	
	private Contato contato;
}
