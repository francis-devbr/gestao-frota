package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Privilegio;

public interface PrivilegioRepository extends JpaRepository<Privilegio, Long> {

	Privilegio findByNome(String nome);

}
