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
import javax.persistence.JoinColumn;
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

		@ManyToOne
		@JoinColumn(name="usuario_id", nullable=false)
		private Usuario usuario;
		
		@ManyToOne
		@JoinColumn(name="dependencia_id", nullable=false)
		private Dependencia dependencia;
		
		@Column(name = "empezado_en")
		private Date fechaInicio;

		public UsuarioDependencia() {
		}
		
		public UsuarioDependencia(Usuario usuario, Dependencia dependencia) {
			this.usuario = usuario;
			this.dependencia = dependencia;
			this.fechaInicio = new Date();
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Dependencia getDependencia() {
			return dependencia;
		}

		public void setDependencia(Dependencia dependencia) {
			this.dependencia = dependencia;
		}

		public Date getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		
	
	
}
