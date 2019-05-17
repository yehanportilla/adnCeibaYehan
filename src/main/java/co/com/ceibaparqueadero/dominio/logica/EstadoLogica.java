package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceibaparqueadero.dominio.dto.EstadoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.EstadoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.EstadoRepositorio;

@RestController
public class EstadoLogica {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Autowired
	EstadoRepositorio estadoRepositorio;

	/**
	 * Metodo encargado de listar estado
	 * 
	 * @return List<Estado>
	 */
	public List<EstadoEntidad> listarEstado() {
		return estadoRepositorio.findAll();
	}

	/**
	 * Metodo encargado de guardar el estado
	 * 
	 * @param detalleEstado
	 * @return
	 */
	public EstadoDto guardarEstado(EstadoDto estadoDto) throws ParqueaderoExcepcion {

		EstadoEntidad creaEstado = estadoRepositorio.save(EstadoBuilder.convertirAEntidad(estadoDto));

		if (creaEstado == null) {
			throw new ParqueaderoExcepcion(MENSAJE_ERROR);
		}
		return estadoDto;

	}

}
