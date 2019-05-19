package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import javax.persistence.Entity;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Marca extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@NonNull
	private String nome;
}
