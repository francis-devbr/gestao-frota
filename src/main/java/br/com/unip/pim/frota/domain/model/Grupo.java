package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Grupo {

	private Long id;
	private String nome;
	
}
