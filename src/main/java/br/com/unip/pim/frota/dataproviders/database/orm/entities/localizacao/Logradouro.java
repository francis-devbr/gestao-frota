package br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
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
public class Logradouro extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String cep;

	@NotNull
	private String nome;

	@NotNull
	@ManyToOne
	private Bairro bairro;
}