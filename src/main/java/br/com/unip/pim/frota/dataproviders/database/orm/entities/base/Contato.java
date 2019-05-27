package br.com.unip.pim.frota.dataproviders.database.orm.entities.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id", referencedColumnName = "id")
	private List<Telefone> telefones;

	@Column(unique = true)
	private String email;
}