package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.TiempoDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;

public class TiempoBuilder {

	TiempoBuilder() {
	}

	/*
	 * Metodo encargado de convertir de dto a entidad
	 */
	public static TiempoDto convertirADominio(TiempoEntidad tiempoEntidad) {

		TiempoDto tiempoDto = null;

		if (tiempoEntidad != null) {

			tiempoDto = new TiempoDto(tiempoEntidad.getId(), tiempoEntidad.getNombre());
		}
		return tiempoDto;
	}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */
	public static TiempoEntidad convertirAEntidad(TiempoDto tiempoDto) {

		TiempoEntidad tiempoEntidad = null;

		if (tiempoDto != null) {

			tiempoEntidad = new TiempoEntidad(tiempoDto.getId(), tiempoDto.getNombre());
		}
		return tiempoEntidad;
	}

}
