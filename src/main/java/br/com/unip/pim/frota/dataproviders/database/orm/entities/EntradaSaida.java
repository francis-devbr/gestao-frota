package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EntradaSaida extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@Getter
	private Pessoa pessoa;
	
	@Getter
	private Veiculo veiculo;
	
	@Getter
	private LocalDateTime entradaEm;
	
	@Getter
	private LocalDateTime saidaEm;
}
