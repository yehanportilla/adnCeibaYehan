package co.com.ceibaparqueadero.dominio.dto;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;

public class TarifaDto {

	private Long id;
	private Double valor;
	private ClaseAutomotorEntidad claseAutomotorEntidad;
	private TiempoEntidad tiempoEntidad;

	public TarifaDto() {

	}

	public TarifaDto(Long id, Double valor, ClaseAutomotorEntidad claseAutomotorEntidad, TiempoEntidad tiempoEntidad) {
		this.id = id;
		this.valor = valor;
		this.claseAutomotorEntidad = claseAutomotorEntidad;
		this.tiempoEntidad = tiempoEntidad;
	}

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

	public ClaseAutomotorEntidad getClaseAutomotorEntidad() {
		return claseAutomotorEntidad;
	}

	public void setClaseAutomotorEntidad(ClaseAutomotorEntidad claseAutomotorEntidad) {
		this.claseAutomotorEntidad = claseAutomotorEntidad;
	}

	public TiempoEntidad getTiempoEntidad() {
		return tiempoEntidad;
	}

	public void setTiempoEntidad(TiempoEntidad tiempoEntidad) {
		this.tiempoEntidad = tiempoEntidad;
	}

}
