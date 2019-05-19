package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	private Long id;
	private Pessoa pessoa;
	private Usuario usuario;
	private Boolean status;
}
