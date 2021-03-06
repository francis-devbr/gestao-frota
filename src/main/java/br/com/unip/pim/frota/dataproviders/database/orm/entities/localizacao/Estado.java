package br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Estado extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(unique = true)
	private String sigla;

	@NotNull
	private String nome;

	@ManyToOne
	private Pais pais;

}
