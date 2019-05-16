package co.com.ceibaparqueadero.dominio.exepciones;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;

public class Respuesta {

	private String mensaje;
	private Integer codigo;
	
	
	private ClaseAutomotorEntidad claseAutomotorEntidad;
	private TiempoEntidad tiempoEntidad;
	private EstadoEntidad estadoEntidad;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public EstadoEntidad getEstado() {
		return estadoEntidad;
	}

	public void setEstado(EstadoEntidad estadoEntidad) {
		this.estadoEntidad = estadoEntidad;
	}
	
	

}
