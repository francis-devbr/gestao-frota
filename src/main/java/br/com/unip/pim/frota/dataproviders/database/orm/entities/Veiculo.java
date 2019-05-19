package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDateTime;

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
public class Veiculo extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	private String placa;

	@NonNull
	@Getter
	private String chassi;

	@NonNull
	@Getter
	private Modelo modelo;

	@NonNull
	@Getter
	private Marca marca;
}
