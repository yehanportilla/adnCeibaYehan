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
@Table(name = "automotor")
@EntityListeners(AuditingEntityListener.class) // para hacer auditoria
public class Automotor {

	@Id
	@Column(name = "AUTOMOTOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "AUTOMOTOR_PLACA")
	private String placa;

	@Column(name = "AUTOMOTOR_CILINDRAGE")
	private Long cilindraje;

	@ManyToOne
	@JoinColumn(name = "CLASE_ID")
	private ClaseAutomotor claseAutomotor;

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

	public ClaseAutomotor getClaseAutomotor() {
		return claseAutomotor;
	}

	public void setClaseAutomotor(ClaseAutomotor claseAutomotor) {
		this.claseAutomotor = claseAutomotor;
	}

}
