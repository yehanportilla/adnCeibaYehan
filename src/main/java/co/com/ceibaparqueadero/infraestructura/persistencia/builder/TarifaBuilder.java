package co.com.ceibaparqueadero.infraestructura.persistencia.builder;

import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;

public class TarifaBuilder {

	TarifaBuilder() {}

	/*
	 * Metodo encargado de convertir de entidad a dto
	 */
	public static TarifaEntidad convertirAEntidad(TarifaDto tarifaDto) {

		TarifaEntidad tarifaEntidad = null;

		if (tarifaDto != null) {
			tarifaEntidad = new TarifaEntidad(tarifaDto.getId(), tarifaDto.getValor(),
					tarifaDto.getClaseAutomotorEntidad(), tarifaDto.getTiempoEntidad());
		}

		return tarifaEntidad;
	}

}
