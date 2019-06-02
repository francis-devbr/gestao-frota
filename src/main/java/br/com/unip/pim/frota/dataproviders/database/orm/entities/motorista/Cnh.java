package br.com.unip.pim.frota.dataproviders.database.orm.entities.motorista;

import java.time.LocalDate;

import javax.persistence.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Cnh extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	
	private LocalDate renovaEm;
	
	private String categoria;
}
