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
	
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioDependencia> dependencias = new ArrayList<>();
	
	//================

	public Usuario(String nombre, String nick, String pwd, String email) {
		this.nombre = nombre;
		this.nick = nick;
		this.pwd = (new BCryptPasswordEncoder().encode(pwd));

		this.email = email;
		this.dependencias = new ArrayList<UsuarioDependencia>();
	}
	
	
	public List<UsuarioDependencia> getDependencias() {
		return dependencias;
	}

	public void setDependencias(List<UsuarioDependencia> dependencias) {
		this.dependencias = dependencias;
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
	
}
