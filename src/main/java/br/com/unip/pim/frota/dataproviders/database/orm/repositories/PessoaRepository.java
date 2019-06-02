package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByCpfOuCnpj(String cpfOuCnpj);
	
}
