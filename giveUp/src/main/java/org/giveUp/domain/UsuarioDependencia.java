package org.giveUp.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "usuarioDependencia")
@Table(name = "usuario_dependencia")
public class UsuarioDependencia {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@ManyToOne(fetch = FetchType.LAZY)
    	@MapsId("usuarioId")
		private Long usuario;
		
		@ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("dependenciaId")
		private Long dependencia;
		
		@Column(name = "empezado_en")
		private Date fechaInicio = new Date();

		public UsuarioDependencia() {
		}
		
		public UsuarioDependencia(Long usuario, Long dependencia) {
			this.usuario = usuario;
			this.dependencia = dependencia;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Long getUsuario() {
			return usuario;
		}

		public void setUsuario(Long usuario) {
			this.usuario = usuario;
		}

		public Long getDependencia() {
			return dependencia;
		}

		public void setDependencia(Long dependencia) {
			this.dependencia = dependencia;
		}

		public Date getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
 
        if (o == null || getClass() != o.getClass()) {
        	return false;	
        }
 
        UsuarioDependencia that = (UsuarioDependencia) o;
        return Objects.equals(usuario, that.usuario) &&
               Objects.equals(dependencia, that.dependencia);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(usuario, dependencia);
    }
	
	
}
