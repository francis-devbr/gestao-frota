package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String senha;
	private LocalDateTime ultimoAcessoEm;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	private Boolean isAtivo;

	@ManyToMany
    @JoinTable( 
        name = "usuarios_regras", 
        joinColumns = @JoinColumn(
          name = "usuario_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "regra_id", referencedColumnName = "id")) 
    private Collection<Regra> regras;
}