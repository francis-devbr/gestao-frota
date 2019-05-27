package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Funcionario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Reserva extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Motorista motorista;

	@NotNull
	private LocalDateTime retiraEm;

	private LocalDateTime entregaEm;

	@OneToOne
	private Funcionario funcionario;

}
