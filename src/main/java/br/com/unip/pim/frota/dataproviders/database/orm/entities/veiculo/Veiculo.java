package br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Veiculo extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String placa;

	@NotNull
	private String chassi;

	private String versao;

	@NotNull
	private String kmInicial;

	private String kmFinal;

	private String observacao;

	@NotNull
	@ManyToOne
	private TipoCombustivel tipoCombustivel;

	@NotNull
	private Integer anoFabricacao;

	@NotNull
	private Integer anoModelo;

	@NotNull
	private String cor;

	@NotNull
	@ManyToOne
	private Categoria categoriaVeiculo;

	@NotNull
	@ManyToOne
	private Marca marca;

	@NotNull
	private Boolean isEnable;
}
