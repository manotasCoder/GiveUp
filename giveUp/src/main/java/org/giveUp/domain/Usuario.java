package org.giveUp.domain;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	
	@Column(unique = true)
	private String nick;
	
	private String pwd;
	
	private String email;
	
	@OneToMany(
	        mappedBy = "usuario",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<UsuarioDependencia> dependencias2 = new ArrayList<>();
	
	@ManyToMany
	private Collection<Dependencia> dependencias;
	
	@ManyToMany
	private Collection veces;
	
	//================

	public Usuario(String nombre, String nick, String pwd, String email) {
		this.nombre = nombre;
		this.nick = nick;
		this.pwd = (new BCryptPasswordEncoder().encode(pwd));

		this.email = email;
		this.dependencias = new ArrayList<Dependencia>();
		this.dependencias2 = new ArrayList<UsuarioDependencia>();
	}
	
	
	public List<UsuarioDependencia> getDependencias2() {
		return dependencias2;
	}

	public void setDependencias2(List<UsuarioDependencia> dependencias2) {
		this.dependencias2 = dependencias2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Dependencia> getDependencias() {
		return dependencias;
	}

	public void setDependencias(Collection<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public Collection getVeces() {
		return veces;
	}

	public void setVeces(Collection veces) {
		this.veces = veces;
	}
	
	
	
	
	
}
