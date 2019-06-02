package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Cidade;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findByNomeAndEstado(String nome, Estado estado);

}
