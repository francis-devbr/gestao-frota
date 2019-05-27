package br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Empresa extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Pessoa pessoa;

	@NotNull
	private Boolean isEnable;
}
