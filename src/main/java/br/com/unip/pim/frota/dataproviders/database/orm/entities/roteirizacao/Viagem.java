package br.com.unip.pim.frota.dataproviders.database.orm.entities.roteirizacao;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.Motorista;
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
public class Viagem extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Motorista motorista;
	
	@OneToMany
	private Collection<Funcionario> funcionarios;
	
	@NotNull
	private String origem;
	
	@NotNull
	private String destino;
	
	private LocalDate viegemRealizadaEm;
	
}
