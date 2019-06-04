package br.com.unip.pim.frota.dataproviders.database.orm.entities.motorista;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
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
public class Motorista extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cnh_id", referencedColumnName = "id")
	@NotNull
	private Cnh cnh;

	private Boolean isEnable;

}
