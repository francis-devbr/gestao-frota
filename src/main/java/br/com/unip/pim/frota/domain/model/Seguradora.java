package br.com.unip.pim.frota.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Seguradora {

	@Id
	private Long id;
	
	private Pessoa pessoa;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;
	
	private Boolean isAtivo;
}
