package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Endereco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String cep;

	@NonNull
	@Getter
	@Setter
	private String logradouro;

	@NonNull
	@Getter
	@Setter
	private String numero;

	@NonNull
	@Getter
	@Setter
	private String complemento;

	@NonNull
	@Getter
	@Setter
	private String bairro;

	@NonNull
	@Getter
	@Setter
	private String cidade;

	@NonNull
	@Getter
	@Setter
	private String uf;

	@NonNull
	@Getter
	@Setter
	private String pais;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}