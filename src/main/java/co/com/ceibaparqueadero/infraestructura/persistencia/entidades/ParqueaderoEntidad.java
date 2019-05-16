package co.com.ceibaparqueadero.infraestructura.persistencia.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

public class ParqueaderoEntidad {

	@Entity
	@Table(name = "parqueo")
	@EntityListeners(AuditingEntityListener.class) // para hacer auditoria
	public class Parqueo {

		@Id
		@Column(name = "PARQUEO_ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "PLACA")
		private String placa;

		@Column(name = "CILINDRAJE")
		private Long cilindraje;

		@Column(name = "FECHA_REGISTRO")
		@DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
		private Date fechaRegistro;

		@Column(name = "FECHA_SALIDA")
		@DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
		private Date fechaSalida;

		@Column(name = "VALOR")
		private Double valor;

		@ManyToOne
		@JoinColumn(name = "CLASE_ID")
		private ClaseAutomotorEntidad claseAutomotorEntidad;

		@ManyToOne
		@JoinColumn(name = "ESTADO_ID")
		private EstadoEntidad estadoEntidad;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public Long getCilindraje() {
			return cilindraje;
		}

		public void setCilindraje(Long cilindraje) {
			this.cilindraje = cilindraje;
		}

		public Date getFechaRegistro() {
			return fechaRegistro;
		}

		public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}

		public Date getFechaSalida() {
			return fechaSalida;
		}

		public void setFechaSalida(Date fechaSalida) {
			this.fechaSalida = fechaSalida;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public ClaseAutomotorEntidad getClaseAutomotor() {
			return claseAutomotorEntidad;
		}

		public void setClaseAutomotor(ClaseAutomotorEntidad claseAutomotorEntidad) {
			this.claseAutomotorEntidad = claseAutomotorEntidad;
		}

		public EstadoEntidad getEstado() {
			return estadoEntidad;
		}

		public void setEstado(EstadoEntidad estadoEntidad) {
			this.estadoEntidad = estadoEntidad;
		}

	}
}
