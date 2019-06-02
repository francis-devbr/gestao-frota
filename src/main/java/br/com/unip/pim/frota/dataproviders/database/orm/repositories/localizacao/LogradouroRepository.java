package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Logradouro;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

	Logradouro findByCep(String cep);
	
}
