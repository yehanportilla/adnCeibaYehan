package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.EstadoDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;

public class EstadoBuilder {

	EstadoBuilder() {

	}

	/*
	 * Metodo encargado de convertir de dto a entidad
	 */
	public static EstadoDto convertirADominio(EstadoEntidad estadoEntidad) {

		EstadoDto estadoDto = null;

		if (estadoEntidad != null) {

			estadoDto = new EstadoDto(estadoEntidad.getId(), estadoEntidad.getNombre());
		}

		return estadoDto;
	}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */

	public static EstadoEntidad convertirAEntidad(EstadoDto estadoDto) {

		EstadoEntidad estadoEntidad = null;

		if (estadoDto != null) {

			estadoEntidad = new EstadoEntidad(estadoDto.getId(), estadoDto.getNombre());
		}
		return estadoEntidad;

	}

}
