package co.com.ceibaparqueadero.infraestructura.servicios;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;


@RestController
public class ParqueaderoServicio {

	@Autowired
	ParqueaderoLogica parqueaderoLogica;

	/**
	 * Servicio encargado de crear registro para parqueadero
	 * 
	 * @return
	 */
	@GetMapping("/registros")
	public List<ParqueaderoEntidad> listarRegistros() {

		return parqueaderoLogica.listarRegistroAutomotor();
	}
	
	
    /**
     * Metodo encargado de crear registro para parqueadero
     * @param parqueaderoDto
     * @return
     * @throws ParqueaderoExcepcion
     */
	@PostMapping("/registros")
	public ParqueaderoDto registrarAutomotorParqueadero(@Valid @RequestBody ParqueaderoDto parqueaderoDto)throws ParqueaderoExcepcion {
		
		parqueaderoLogica.registrarAutomotorParqueadero(parqueaderoDto);

		return parqueaderoDto;
	}

}
