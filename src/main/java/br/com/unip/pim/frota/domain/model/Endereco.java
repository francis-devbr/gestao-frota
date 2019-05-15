package br.com.unip.pim.frota.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	private Boolean isAtivo;

}
