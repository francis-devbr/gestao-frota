package br.com.unip.pim.frota.domain.model;

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
}