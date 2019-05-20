package co.com.ceibaparqueadero.dominio.logica;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ParqueaderoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;


@Service
public class ParqueaderoLogica {

	@Autowired
	ParqueaderoRepositorio parqueaderoRepositorio;
	
    @Autowired
    ValidacionParqueaderoLogica validacionParqueaderoLogica;
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";


	/**
	 * Metodo encargado de lsitar los registros de automotor
	 * 
	 * @return
	 */
	public List<ParqueaderoEntidad> listarRegistroAutomotor() {

		return parqueaderoRepositorio.findAll();

	}

	/**
	 * Metodo encargado de registrar el automotor.
	 * 
	 * @return
	 */
	public ParqueaderoDto registrarAutomotorParqueadero(ParqueaderoDto parqueaderoDto) throws ParqueaderoExcepcion {

		Date fechaInicial = new Date();

		parqueaderoDto.setFechaRegistro(fechaInicial);
		
		Long tipoAutomotor = parqueaderoDto.getClaseAutomotorEntidad().getId();
		Long estadoAutomotor = parqueaderoDto.getEstadoEntidad().getId();
		
		
		validacionParqueaderoLogica.validarTipoAutomotor(tipoAutomotor);
		
		validacionParqueaderoLogica.validarCilindrada(parqueaderoDto.getCilindraje());
		
		validacionParqueaderoLogica.validarIngresoPlacaDia(parqueaderoDto.getPlaca());
		
		validacionParqueaderoLogica.validarCupoParqueadero(tipoAutomotor, estadoAutomotor);
		
		ParqueaderoEntidad creaRegistro = parqueaderoRepositorio.save(ParqueaderoBuilder.convertirAEntidad(parqueaderoDto));
		
		if (creaRegistro == null) {
			throw new ParqueaderoExcepcion(MENSAJE_ERROR);
		}
		
		return parqueaderoDto;

	}
}
