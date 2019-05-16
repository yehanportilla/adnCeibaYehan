package co.com.ceibaparqueadero.infraestructura.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "clase_automotor")
@EntityListeners(AuditingEntityListener.class) // para hacer auditoria
public class ClaseAutomotorEntidad {

	@Id
	@Column(name = "CLASE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CLASE_NOMBRE")
	private String nombre;

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

	// constructor para clase builder
	public ClaseAutomotorEntidad(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// para que no afecte al listar las clases
	public ClaseAutomotorEntidad() {
	}

}
