package br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@ManyToOne
	private Empresa empresa;

	@ManyToOne
	private Cargo cargo;

	@NotNull
	private String sexo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario user;

	@NotNull
	private Boolean isEnable;

}
