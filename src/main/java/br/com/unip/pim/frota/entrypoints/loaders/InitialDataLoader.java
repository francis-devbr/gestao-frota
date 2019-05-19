package br.com.unip.pim.frota.entrypoints.loaders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.Privilegio;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.Regra;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.Usuario;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.PrivilegioRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.RegraRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.UsuarioRepository;

@Component
public class InitialDataLoader implements
		ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RegraRepository regraRepository;

	@Autowired
	private PrivilegioRepository privilegioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		Privilegio readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilegio writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

		List<Privilegio> adminPrivileges = Arrays.asList(
				readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

		Regra adminRole = regraRepository.findByNome("ROLE_ADMIN");
		Usuario user = Usuario.builder()
				.nome("Teste")
				.senha(passwordEncoder.encode("1234"))
				.regras(Arrays.asList(adminRole))
				.isAtivo(true)
				.build();

		usuarioRepository.save(user);

		alreadySetup = true;
	}

	private Privilegio createPrivilegeIfNotFound(String name) {

		Privilegio privilege = privilegioRepository.findByNome(name);
		if (privilege == null) {
			privilege = Privilegio.builder().nome(name).build();
			privilegioRepository.save(privilege);
		}
		return privilege;
	}

	private Regra createRoleIfNotFound(
			String name, Collection<Privilegio> privileges) {

		Regra role = regraRepository.findByNome(name);
		if (role == null) {
			role = Regra.builder().nome(name).privilegios(privileges).build();
			regraRepository.save(role);
		}
		return role;
	}
}
