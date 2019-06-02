package br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.manutencao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Veiculo;
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
public class Manutencao extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Veiculo veiculo;

	private LocalDate inicio;

	private LocalDate fim;

	@ManyToOne
	private TipoManutencao tipoManutencao;

}
