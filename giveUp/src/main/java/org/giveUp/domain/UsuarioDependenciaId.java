package org.giveUp.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class UsuarioDependenciaId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="usuario_id")
	private Long usuarioId;
	
	@Column(name="dependencia_id")
	private Long dependenciaId;

	public UsuarioDependenciaId() {
	}
	
	public UsuarioDependenciaId(Long usuarioId, Long dependenciaId) {
		this.usuarioId = usuarioId;
		this.dependenciaId = dependenciaId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getDependenciaId() {
		return dependenciaId;
	}

	public void setDependenciaId(Long dependenciaId) {
		this.dependenciaId = dependenciaId;
	}
	

@Override
public boolean equals(Object o) {
    if (this == o) {
    	return true;
    }

    if (o == null || getClass() != o.getClass()) {
    	return false;	
    }

    UsuarioDependenciaId that = (UsuarioDependenciaId) o;
    return Objects.equals(usuarioId, that.usuarioId) &&
           Objects.equals(dependenciaId, that.dependenciaId);
}

@Override
public int hashCode() {
    return Objects.hash(usuarioId, dependenciaId);
}

}
