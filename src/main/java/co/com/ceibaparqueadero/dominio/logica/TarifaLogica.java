package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TarifaBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;

@Service
public class TarifaLogica {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Autowired
	TarifaRepositorio tarifaRepositorio;

	@Autowired
	TiempoRepositorio tiempoRepositorio;

	@Autowired
	ClaseAutomotorRepositorio claseAutomotorRepositorio;

	@Autowired
	TiempoLogica tiempoLogica;

	@Autowired
	ClaseAutomotorLogica claseAutomotorLogica;

	/**
	 * Metodo encargado de listar las tarifas
	 * 
	 * @return List<Tarifa>
	 */
	public List<TarifaEntidad> listarTarifa() {
		return tarifaRepositorio.findAll();
	}

	/**
	 * Metodo encargado de guardar la tarifa
	 * 
	 * @param tarifaEntidad
	 * @return
	 */

	public TarifaDto guardarTarifa(TarifaDto tarifaDto) throws ParqueaderoExcepcion {

		Optional<TiempoEntidad> tiempo = tiempoLogica.buscarPorIdTiempo(tarifaDto.getTiempoEntidad().getId());

		Optional<ClaseAutomotorEntidad> clase = claseAutomotorLogica.buscarPorIdClase(tarifaDto.getClaseAutomotorEntidad().getId());

		if (tiempo.isPresent() && clase.isPresent()) {

			TiempoEntidad tiempoEntidad = tiempo.get();
			tarifaDto.setTiempoEntidad(tiempoEntidad);

			ClaseAutomotorEntidad claseAutomotorEntidad = clase.get();
			tarifaDto.setClaseAutomotorEntidad(claseAutomotorEntidad);

			TarifaEntidad creaTarifa = tarifaRepositorio.save(TarifaBuilder.convertirAEntidad(tarifaDto));

			if (creaTarifa == null) {
				throw new ParqueaderoExcepcion(MENSAJE_ERROR);
			}
		}
		return tarifaDto;
	}
}
