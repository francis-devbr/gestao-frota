package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pessoa {

	@Id
	private Long id;
	
	private String nome;
	
	private String cpfCnpj;
	
	private Endereco endereco;
	
	private Contato contato;
}
