package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Long> {

	List<Bairro> findByNome(String nome);
	
}
