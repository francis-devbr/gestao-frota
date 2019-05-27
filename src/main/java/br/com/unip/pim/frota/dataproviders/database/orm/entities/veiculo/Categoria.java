package br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo;

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
public class Categoria extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	private String nome;

	@NonNull
	private Boolean isEnable;

}
