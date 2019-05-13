package co.com.ceibaparqueadero.infraestructura.entidades;

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

@Entity
@Table(name = "movimiento")
@EntityListeners(AuditingEntityListener.class)
public class Movimiento {

	@Id
	@Column(name = "MOVIMIENTO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MOVIMIENTO_FECHAREG")
	private String fechaRegistro;

	@Column(name = "MOVIMIENTO_FECHAFIN")
	private String fechaFin;

	@Column(name = "MOVIMIENTO_VALOR")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "AUTOMOTOR_ID")
	private Automotor automotor;

	@ManyToOne
	@JoinColumn(name = "ESTADO_ID")
	private Estado estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Automotor getAutomotor() {
		return automotor;
	}

	public void setAutomotor(Automotor automotor) {
		this.automotor = automotor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
