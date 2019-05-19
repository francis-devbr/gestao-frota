package br.com.unip.pim.frota.dataproviders.database.orm.entities;

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
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.PessoaGroupSequenceProvider;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.group.CnpjGroup;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.validation.group.CpfGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class Pessoa extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@NonNull
	@Getter
	@Setter
	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@NonNull
	@Getter
	@Setter
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "cpf_cnpj", unique = true)
	private String cpfOuCnpj;

	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_enderecos", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
	private List<Endereco> enderecos = new ArrayList<>();

	@NonNull
	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_papeis", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "papel_id", referencedColumnName = "id"))
	private List<Papel> papeis = new ArrayList<>();

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private List<Contato> contatos = new ArrayList<>();

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario user;

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