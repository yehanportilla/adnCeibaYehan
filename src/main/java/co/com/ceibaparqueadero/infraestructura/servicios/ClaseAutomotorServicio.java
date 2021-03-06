package co.com.ceibaparqueadero.infraestructura.servicios;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.ClaseAutomotorDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;


@RestController
public class ClaseAutomotorServicio {

	@Autowired
	ClaseAutomotorLogica claseAutomotorLogica;

	/**
	 * Servicio en cargado de consultar clase de vehiculo
	 * 
	 * @return List<ClaseAutomotor>
	 */
	@GetMapping("/clases")
	public List<ClaseAutomotorEntidad> listaClases() {

		return claseAutomotorLogica.listarClases();

	}

	/**
	 * Servicio encargado de guardar clase automotor
	 * 
	 * @param detalleClase
	 */
	@PostMapping("/clases")
	public ClaseAutomotorDto guardarClaseVehiculo(@Valid @RequestBody ClaseAutomotorDto claseAutomotorDto) throws ParqueaderoExcepcion {

		return claseAutomotorLogica.guardarClaseAutomor(claseAutomotorDto);

	}

}
