package br.com.unip.pim.frota.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Veiculo {

	@Id
	private Long id;
	
	private String placa;

	private String chassi;
	
	private Modelo modelo;
	
	private Marca marca;
}
