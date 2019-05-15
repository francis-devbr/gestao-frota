package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Seguradora {

	@Id
	private Long id;
	
	private Pessoa pessoa;
}
