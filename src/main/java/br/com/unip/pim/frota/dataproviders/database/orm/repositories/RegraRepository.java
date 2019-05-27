package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long>{

	Regra findByNome(String nome);

}
