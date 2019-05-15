package br.com.unip.pim.frota.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Seguro {

	@Id
	private Long id;
	
	private LocalDate inicioVigenciaEm;
	
	private LocalDate fimVigenciaEm;
	
	private Veiculo veiculo;
	
	private Seguradora seguradora;
	
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
}
