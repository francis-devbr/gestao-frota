package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String tipo;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "contato_id", referencedColumnName = "id")
	private List<Telefone> telefones;

	@Getter
	@Setter
	@Column(unique = true)
	private String email;
}