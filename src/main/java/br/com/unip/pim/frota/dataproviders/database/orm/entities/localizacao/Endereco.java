package br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Endereco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String cep;

	@NonNull
	private String logradouro;

	@NonNull
	private String numero;

	@NonNull
	private String complemento;

	@NonNull
	@ManyToOne
	private Bairro bairro;

	@NonNull
	private Boolean isEnable;

}