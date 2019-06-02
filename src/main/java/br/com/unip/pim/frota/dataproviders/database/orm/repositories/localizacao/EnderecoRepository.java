package br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
