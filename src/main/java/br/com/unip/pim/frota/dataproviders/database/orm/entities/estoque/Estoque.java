package br.com.unip.pim.frota.dataproviders.database.orm.entities.estoque;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {

	@OneToMany
	List<Produto> produtos;

	private BigDecimal quantidade;
	
	
}
