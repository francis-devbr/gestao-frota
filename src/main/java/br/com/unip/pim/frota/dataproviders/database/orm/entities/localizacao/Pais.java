package br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao;

import javax.persistence.Entity;

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
public class Pais extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	private String sigla;

	private String nome;

}
