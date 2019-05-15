package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Funcionario {
	@Id
	private Long id;
	private Pessoa pessoa;
	private Boolean status;
}
