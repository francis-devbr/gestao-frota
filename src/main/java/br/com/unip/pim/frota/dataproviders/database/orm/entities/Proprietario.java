package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Proprietario extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@OneToMany
	@JoinColumn(name = "proprietario_id", referencedColumnName = "id")
	private Collection<Veiculo> veiculos;

	@NonNull
	private Boolean isEnable;

}
