package br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoCombustivel extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String nome;
	
	@NonNull
	private Boolean isEnable;
}
