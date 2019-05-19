package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Privilegio {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
 
    @ManyToMany(mappedBy = "privilegios")
    private Collection<Regra> regras;
    
}
