package co.com.ceibaparqueadero.infraestructura.persistencia.entidades;

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
@Table(name = "tarifa")
@EntityListeners(AuditingEntityListener.class)
public class TarifaEntidad {

	@Id
	@Column(name = "TARIFA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TARIFA_VALOR")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "CLASE_ID")
	private ClaseAutomotorEntidad claseAutomotorEntidad;

	@ManyToOne
	@JoinColumn(name = "TIEMPO_ID")
	private TiempoEntidad tiempoEntidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TiempoEntidad getTiempo() {
		return tiempoEntidad;
	}

	public void setTiempo(TiempoEntidad tiempoEntidad) {
		this.tiempoEntidad = tiempoEntidad;
	}

}
