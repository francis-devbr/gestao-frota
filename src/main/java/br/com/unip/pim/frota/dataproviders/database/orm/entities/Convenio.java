package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Convenio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Empresa empresa;

	@NotNull
	private String nome;

	@NotNull
	private String tipoConvenio;

	@NotNull
	private Boolean isEnable;

}
