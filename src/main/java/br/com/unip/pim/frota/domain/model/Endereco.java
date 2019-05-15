package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Endereco {

	private Long id;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
}
