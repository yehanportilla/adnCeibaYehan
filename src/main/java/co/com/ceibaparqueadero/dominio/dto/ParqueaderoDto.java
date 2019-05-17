package co.com.ceibaparqueadero.dominio.dto;

import java.util.Date;


import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;

public class ParqueaderoDto {

	private Long id;
	private String placa;
	private Long cilindraje;
	private Date fechaRegistro;
	private Date fechaSalida;
	private Double valor;
	private ClaseAutomotorEntidad claseAutomotorEntidad;
	private EstadoEntidad estadoEntidad;

	public ParqueaderoDto() {

	}

	public ParqueaderoDto(Long id, String placa, Long cilindraje, Date fechaRegistro, Date fechaSalida, Double valor,
			ClaseAutomotorEntidad claseAutomotorEntidad, EstadoEntidad estadoEntidad) {
		super();
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaRegistro = fechaRegistro;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.claseAutomotorEntidad = claseAutomotorEntidad;
		this.estadoEntidad = estadoEntidad;
	}

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

	public ClaseAutomotorEntidad getClaseAutomotorEntidad() {
		return claseAutomotorEntidad;
	}

	public void setClaseAutomotorEntidad(ClaseAutomotorEntidad claseAutomotorEntidad) {
		this.claseAutomotorEntidad = claseAutomotorEntidad;
	}

	public EstadoEntidad getEstadoEntidad() {
		return estadoEntidad;
	}

	public void setEstadoEntidad(EstadoEntidad estadoEntidad) {
		this.estadoEntidad = estadoEntidad;
	}

}
