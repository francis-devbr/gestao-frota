package br.com.unip.pim.frota.dataproviders.database.orm.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@NonNull
	@Setter
	@Column(unique=true)
	private String username;
    
	@NonNull
	@Getter
	@Setter
    private String password;
    
	@Getter
	@Setter
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "usuarios_roles", 
        joinColumns = @JoinColumn(
          name = "usuario_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "regra_id", referencedColumnName = "id")) 
    private Collection<Regra> regras;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}