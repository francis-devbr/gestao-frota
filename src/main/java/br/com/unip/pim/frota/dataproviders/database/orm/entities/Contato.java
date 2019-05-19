package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;
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
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
}
