package br.com.unip.pim.frota.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Locacao {

	@Id
	private Long id;
	
	private Veiculo veiculo;
	
	private Cliente cliente;
	
	private Motorista motorista;
	
	private LocalDate locadoEm;
	
	private LocalDate devolveEm;
	
}
