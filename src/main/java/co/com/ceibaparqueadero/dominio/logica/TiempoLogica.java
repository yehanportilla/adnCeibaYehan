package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceibaparqueadero.dominio.dto.TiempoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TiempoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;

@RestController
public class TiempoLogica {
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Autowired
	TiempoRepositorio tiempoRepositorio;

	/**
	 * Metodo encargado de listar tiempos
	 * 
	 * @return List<Tiempo>
	 */
	public List<TiempoEntidad> listarTiempo() {
		return tiempoRepositorio.findAll();
	}

	/**
	 * Metodo encargado de guardar el tiempo
	 * 
	 * @param detalleTiempo
	 * @return
	 */
	public TiempoDto guardarTiempo(TiempoDto tiempoDto) throws ParqueaderoExcepcion {

		TiempoEntidad creaTiempo = tiempoRepositorio.save(TiempoBuilder.convertirAEntidad(tiempoDto));

		if (creaTiempo == null) {

			throw new ParqueaderoExcepcion(MENSAJE_ERROR);
		}

		return tiempoDto;

	}

}
