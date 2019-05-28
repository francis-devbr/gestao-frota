package br.com.unip.pim.frota.dataproviders.database.orm.entities.base;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Telefone extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String tipo;

	@NotNull
	private String ddd;

	@NotNull
	private String numero;

	@NotNull
	private Boolean isEnable;
}