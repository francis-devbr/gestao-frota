package br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Marca extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String nome;
	
	@NonNull
	@OneToMany
	private Collection<Modelo> modelo;

	@NonNull
	private Boolean isEnable;
}
