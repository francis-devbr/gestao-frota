package br.com.unip.pim.frota.domain.model;

import lombok.Data;

@Data
public class Endereco {

	private Long id;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
}
