package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceibaparqueadero.dominio.dto.ClaseAutomotorDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ClaseAutomotorBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;

@RestController
public class ClaseAutomotorLogica {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Autowired
	ClaseAutomotorRepositorio claseAutomotorRepositorio;

	/**
	 * Metodo encargado de consultar las clases de vehiculos
	 * 
	 * @return List<ClaseAutomotor>
	 */
	public List<ClaseAutomotorEntidad> listarClases() {
		return claseAutomotorRepositorio.findAll();

	}

	/**
	 * Metodo encargado de guardar la clase automotor
	 * 
	 * @param claseAutomotor
	 * @return
	 */
	public ClaseAutomotorDto guardarClaseAutomor(ClaseAutomotorDto claseAutomotorDto) throws ParqueaderoExcepcion {

		ClaseAutomotorEntidad creaClase = claseAutomotorRepositorio
				.save(ClaseAutomotorBuilder.convertirAEntidad(claseAutomotorDto));

		if (creaClase == null) {

			throw new ParqueaderoExcepcion(MENSAJE_ERROR);
		}
		return claseAutomotorDto;

	}

	/**
	 * Metodo encargado de consultar
	 * 
	 * @param id
	 * @return
	 */
	public Optional<ClaseAutomotorEntidad> buscarPorIdClase(Long id) {

		return claseAutomotorRepositorio.findById(id);

	}

}
