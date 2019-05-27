package br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
public class Endereco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Logradouro logradouro;

	@NotNull
	private String numero;

	@NotNull
	private String complemento;

	@NotNull
	private Boolean isEnable;

}