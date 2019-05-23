package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;

public class ParqueaderoBuilder {

	ParqueaderoBuilder() {}

	/*
	 * Metodo encargado de convertir de dto a entidad
	 */

	public static ParqueaderoDto convertirADominio(ParqueaderoEntidad parqueaderoEntidad) {

		ParqueaderoDto parqueaderoDto = null;

		if (parqueaderoEntidad != null) {

			parqueaderoDto = new ParqueaderoDto(parqueaderoEntidad.getId(), parqueaderoEntidad.getPlaca(),
					parqueaderoEntidad.getCilindraje(), parqueaderoEntidad.getFechaRegistro(),
					parqueaderoEntidad.getFechaSalida(), parqueaderoEntidad.getValor(),
					parqueaderoEntidad.getClaseAutomotorEntidad(), parqueaderoEntidad.getEstadoEntidad());
		}
		return parqueaderoDto;
	}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */

	public static ParqueaderoEntidad convertirAEntidad(ParqueaderoDto parqueaderoDto) {

		ParqueaderoEntidad parqueaderoEntidad = null;

		if (parqueaderoDto != null) {

			parqueaderoEntidad = new ParqueaderoEntidad(parqueaderoDto.getId(), parqueaderoDto.getPlaca(),
					parqueaderoDto.getCilindraje(), parqueaderoDto.getFechaRegistro(), parqueaderoDto.getFechaSalida(),
					parqueaderoDto.getValor(), parqueaderoDto.getClaseAutomotorEntidad(),
					parqueaderoDto.getEstadoEntidad());
		}

		return parqueaderoEntidad;
	}

}
