package br.com.unip.pim.frota.dataproviders.database.orm.entities.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.PessoaGroupSequenceProvider;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.group.CnpjGroup;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.group.CpfGroup;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class Pessoa extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@NotNull
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "cpf_cnpj", unique = true)
	private String cpfOuCnpj;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_enderecos", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private List<Contato> contatos = new ArrayList<>();

	private String foto;

	@PrePersist
	@PreUpdate
	private void prePersistPreUpdate() {
		this.cpfOuCnpj = TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}

	@PostLoad
	private void postLoad() {
		this.cpfOuCnpj = this.tipoPessoa.formatar(this.cpfOuCnpj);
	}

	public String getCpfOuCnpjSemFormatacao() {
		return TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}
}