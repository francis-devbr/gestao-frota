package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Regra {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String nome;
    @ManyToMany(mappedBy = "regras")
    private Collection<Usuario> usuarios;
 
    @ManyToMany
    @JoinTable(
        name = "regras_privilegios", 
        joinColumns = @JoinColumn(
          name = "regra_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilegio_id", referencedColumnName = "id"))
	private Collection<Privilegio> privilegios;

}
