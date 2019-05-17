package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.ClaseAutomotorDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;

public class ClaseAutomotorBuilder {

	ClaseAutomotorBuilder() {

	}

	/*
	 * Metodo encargado de convertir de dto a entidad
	 */

	public static ClaseAutomotorDto convertirADominio(ClaseAutomotorEntidad claseAutomotorEntidad) {

		ClaseAutomotorDto claseAutomotorDto = null;

		if (claseAutomotorEntidad != null) {

			claseAutomotorDto = new ClaseAutomotorDto(claseAutomotorEntidad.getId(), claseAutomotorEntidad.getNombre());
		}

		return claseAutomotorDto;
	}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */
	public static ClaseAutomotorEntidad convertirAEntidad(ClaseAutomotorDto claseAutomotorDto) {

		ClaseAutomotorEntidad claseAutomotorEntidad = null;

		if (claseAutomotorDto != null) {

			claseAutomotorEntidad = new ClaseAutomotorEntidad(claseAutomotorDto.getId(), claseAutomotorDto.getNombre());

		}

		return claseAutomotorEntidad;

	}

}
