package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Cargo findByNome(String nome);

}
