package co.com.ceibaparqueadero.tesintegracion;

import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;

public class ClaseAutomotorBuilder {

	private Long id;
	private String nombre;

	public ClaseAutomotorBuilder() {
		this.id = 4l;
		this.nombre = "Volqueta";
	}

	public ClaseAutomotorBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ClaseAutomotorBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	// nombre del constructor de la clase ClaseAutomotor
	public ClaseAutomotor build() {
		return new ClaseAutomotor(id, nombre);
	}

	public static ClaseAutomotorBuilder anClaseAutomotor() {
		return new ClaseAutomotorBuilder();
	}

}
