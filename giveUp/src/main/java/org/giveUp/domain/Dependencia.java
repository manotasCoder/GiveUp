package org.giveUp.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Dependencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	private String descripcion;
	
	@OneToMany(
			mappedBy = "dependencia",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
			)
	private List<UsuarioDependencia> dependencias = new ArrayList<>();


	//===============
	
	public Dependencia() {
		this.dependencias = new ArrayList<UsuarioDependencia>();
	}
	
	public Dependencia(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dependencias = new ArrayList<UsuarioDependencia>();
	}

	
	
	public List<UsuarioDependencia> getDependencias() {
		return dependencias;
	}

	public void setDependencias(List<UsuarioDependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Dependencia [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dependencias="
				+ dependencias + "]";
	}
	
	

	
	
}
