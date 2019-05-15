package br.com.unip.pim.frota.domain.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Contato {
	
	private Long id;
	
	private String email;
	
	private List<Telefone> telefones;
}
