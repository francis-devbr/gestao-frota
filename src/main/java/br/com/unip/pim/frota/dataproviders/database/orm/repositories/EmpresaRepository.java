package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Empresa findByPessoa(Pessoa pessoa);
}
