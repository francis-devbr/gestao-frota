package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Email {

	@Id
	private Long id;
	private String nome;
	private Boolean isAtivo;
	
}
