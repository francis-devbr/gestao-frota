package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Estado findBySigla(String sigla);

	Estado findByNome(String nome);

}
