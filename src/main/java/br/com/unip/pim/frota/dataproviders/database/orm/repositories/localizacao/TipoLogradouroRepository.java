package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.TipoLogradouro;

public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Long> {

	TipoLogradouro findByNome(String nome);

}
