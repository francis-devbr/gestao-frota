package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pessoa {

	@Id
	private Long id;
	private String nome;
	private String cpfCnpj;
	private String tipoPessoa;
	private List<Endereco> enderecos;
	private Contato contato;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
}
