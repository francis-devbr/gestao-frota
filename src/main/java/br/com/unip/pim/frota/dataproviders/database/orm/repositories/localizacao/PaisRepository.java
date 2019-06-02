package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	Pais findBySigla(String sigla);
	
}
