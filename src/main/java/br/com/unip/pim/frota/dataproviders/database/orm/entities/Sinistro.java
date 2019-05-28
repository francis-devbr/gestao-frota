package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Veiculo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Sinistro extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Veiculo veiculo;

	@NotNull
	private String descricao;

	@NotNull
	private LocalDate dataHora;

}
