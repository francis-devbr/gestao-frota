package br.com.unip.pim.frota.domain.model;

import lombok.Data;

@Data
public class Motorista {
	
	private Long id;
	
	private Pessoa pessoa;
	
	private String cnh;
	
	private Boolean status;
}
