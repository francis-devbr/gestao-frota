package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Telefone {

	@Id
	private Long id;
	private String ddd;
	private String numero;
	private String tipo;
}
