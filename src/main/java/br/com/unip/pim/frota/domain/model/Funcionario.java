package br.com.unip.pim.frota.domain.model;

import lombok.Data;

@Data
public class Funcionario {
	private Long id;
	private Pessoa pessoa;
	private Boolean status;
}
