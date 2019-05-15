package br.com.unip.pim.frota.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {
	@Id
	private Long id;
	private String username;
	private String password;
	private List<Grupo> grupos;
	private LocalDateTime ultimoAcessoEm;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	private Boolean isAtivo;

}