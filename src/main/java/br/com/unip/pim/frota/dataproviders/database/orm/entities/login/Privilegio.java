package br.com.unip.pim.frota.dataproviders.database.orm.entities.login;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Privilegio extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
}
