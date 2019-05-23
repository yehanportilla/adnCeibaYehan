package co.com.ceibaparqueadero.dominio.logica;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ParqueaderoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.EstadoRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;

@RestController
public class SalidaParqueaderoLogica {
	
	private static final String MENSAJE_ERROR = "Error: Al registrar salida vehiculo !";
	private static final String MENSAJE_PLACA_SINREGISTRO = "El vehiculo no se encuentra registrado !";
	private static final Long ESTADO_REGISTRADO = 1l;
	private static final Long ESTADO_PAGADO = 2l;
	
	@Autowired
	ValidacionParqueaderoLogica validacionParqueaderoLogica;
	
	@Autowired
	ParqueaderoRepositorio parqueaderoRepositorio;
	
	@Autowired
	EstadoRepositorio estadoRepositorio;
	
	/**
	 * Metodo encargado de el registro de salida de automotor
	 * @param parqueaderoDto
	 * @return
	 * @throws ParqueaderoExcepcion
	 */
	public ParqueaderoDto registroSalidaAutomotor(String placa) throws ParqueaderoExcepcion{
		
		ParqueaderoEntidad parqueaderoEntidad = parqueaderoRepositorio.obtenerPlacaRegistrada(placa,ESTADO_REGISTRADO);
		Date fechaSalida = new Date();
		
		if(parqueaderoEntidad==null) {
		throw new ParqueaderoExcepcion(MENSAJE_PLACA_SINREGISTRO);
		}
		parqueaderoEntidad.setFechaSalida(fechaSalida);
		Long tipoAutomotor = parqueaderoEntidad.getClaseAutomotorEntidad().getId();
		double valorParqueo = validacionParqueaderoLogica.calcularPrecioAPagar(parqueaderoEntidad.getFechaRegistro(), fechaSalida, tipoAutomotor, parqueaderoEntidad.getCilindraje());
		parqueaderoEntidad.setValor(valorParqueo);
		
		parqueaderoEntidad.setEstadoEntidad(estadoRepositorio.obtenerEstado(ESTADO_PAGADO));
	
		
		 ParqueaderoEntidad registroSalida = parqueaderoRepositorio.save(parqueaderoEntidad);

		if (registroSalida == null) {
			throw new ParqueaderoExcepcion(MENSAJE_ERROR);
		}
		return ParqueaderoBuilder.convertirADominio(parqueaderoEntidad);
	}

}
