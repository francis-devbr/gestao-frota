package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.motorista.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	Motorista findByPessoa(Pessoa pessoa);
}
