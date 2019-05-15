package br.com.unip.pim.frota.domain.model;

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
}
