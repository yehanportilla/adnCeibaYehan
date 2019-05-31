package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.EstadoDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;

public class EstadoBuilder {

	EstadoBuilder() {}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */

	public static EstadoEntidad convertirAEntidad(EstadoDto estadoDto) {

		EstadoEntidad estadoEntidad = null;

		if (estadoDto != null) { // retirar   maper 

			estadoEntidad = new EstadoEntidad(estadoDto.getId(), estadoDto.getNombre());
		}
		return estadoEntidad;

	}

}
