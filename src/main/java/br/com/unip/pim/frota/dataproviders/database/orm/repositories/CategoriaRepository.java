package br.com.unip.pim.frota.dataproviders.database.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
