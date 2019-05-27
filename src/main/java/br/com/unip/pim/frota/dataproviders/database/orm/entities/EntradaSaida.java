package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Veiculo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EntradaSaida extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Motorista motorista;

	@ManyToOne
	private Veiculo veiculo;

	@ManyToOne
	private Convenio convenio;
	
	@NotNull
	private LocalDateTime entradaEm;

	private LocalDateTime saidaEm;
}
