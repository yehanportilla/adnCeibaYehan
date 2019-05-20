package co.com.ceibaparqueadero.tesintegracion;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;

public class ClaseAutomotorBuil {

	private Long id;
	private String nombre;

	public ClaseAutomotorBuil() {
		this.id = 4l;
		this.nombre = "Volqueta";
	}

	public ClaseAutomotorBuil conId(Long id) {
		this.id = id;
		return this;
	}

	public ClaseAutomotorBuil conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	// nombre del constructor de la clase ClaseAutomotor
	public ClaseAutomotorEntidad build() {
		return new ClaseAutomotorEntidad(id, nombre);
	}

	public static ClaseAutomotorBuil anClaseAutomotor() {
		return new ClaseAutomotorBuil();
	}

}
