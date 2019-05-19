package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Apolice extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	private LocalDate inicioVigenciaEm;

	private LocalDate fimVigenciaEm;

	@ManyToOne
	private Veiculo veiculo;

	@ManyToOne
	private Seguradora seguradora;

}
