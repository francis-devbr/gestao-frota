package br.com.unip.pim.frota.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Acesso {
	private Long id;
	private Pessoa pessoa;
	private LocalDateTime entradaEm;
	private LocalDateTime saidaEm;
}
