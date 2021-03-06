package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
	
}
