package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.time.LocalDate;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Veiculo;

public class Sinistro {

	Veiculo veiculo;
	
	String descricao;
	
	LocalDate dataHora;
	
}
