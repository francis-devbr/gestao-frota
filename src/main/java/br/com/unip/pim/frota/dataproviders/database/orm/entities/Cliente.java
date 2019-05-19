package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
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
public class Cliente extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private Pessoa pessoa;

	@NonNull
	private Boolean isEnable;
}
