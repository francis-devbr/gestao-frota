package br.com.unip.pim.frota.dataproviders.database.orm.entities;

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
public class Veiculo extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String placa;

	@NonNull
	private String chassi;

	@NonNull
	private String tipoCombustivel;

	@NonNull
	private Integer anoFabricacao;

	@NonNull
	private Integer anoModelo;

	@NonNull
	@ManyToOne
	private Modelo modelo;

}
