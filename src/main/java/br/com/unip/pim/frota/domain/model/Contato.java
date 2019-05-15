package br.com.unip.pim.frota.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Contato {
	
	@Id
	private Long id;
	private List<Email> emails;
	private List<Telefone> telefones;
}
