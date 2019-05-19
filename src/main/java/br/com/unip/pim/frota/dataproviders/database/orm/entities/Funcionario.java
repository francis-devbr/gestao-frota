package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Funcionario extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@NonNull
	@Getter
	@Setter
	@Column(nullable = false)
	@JsonFormat(pattern = "dd:MM:yyyy")
	private LocalDate dataAdmissao;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd:MM:yyyy")
	private LocalDate dataDemissao;

	@Getter
	@Setter
	private String cargo;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
