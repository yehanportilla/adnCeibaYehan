package co.com.ceibaparqueadero.dominio.utilidades;

import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;
import co.com.ceibaparqueadero.infraestructura.entidades.Estado;
import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

public class Respuesta {

	private String mensaje;
	private Integer codigo;
	private ClaseAutomotor claseAutomotor;
	private Tiempo tiempo;
	private Estado estado;

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

	public ClaseAutomotor getClaseAutomotor() {
		return claseAutomotor;
	}

	public void setClaseAutomotor(ClaseAutomotor claseAutomotor) {
		this.claseAutomotor = claseAutomotor;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
