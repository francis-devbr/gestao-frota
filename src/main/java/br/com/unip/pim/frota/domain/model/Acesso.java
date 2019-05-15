package br.com.unip.pim.frota.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Acesso {
	@Id
	private Long id;
	private Pessoa pessoa;
	private Veiculo veiculo;
	private LocalDateTime entradaEm;
	private LocalDateTime saidaEm;
}
