package br.com.unip.pim.frota.dataproviders.database.orm.entities.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	@Column(unique = true)
	private String email;
}