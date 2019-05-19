package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Fornecedor extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Pessoa pessoa;
	
	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
	
}
