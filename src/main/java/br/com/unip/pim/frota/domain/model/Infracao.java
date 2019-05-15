package br.com.unip.pim.frota.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Infracao {
	@Id
	private Long id;
	
	private Veiculo veiculo;
	
	private Motorista motorista;
	
	private LocalDate infracaoCometidaEm;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;
}
