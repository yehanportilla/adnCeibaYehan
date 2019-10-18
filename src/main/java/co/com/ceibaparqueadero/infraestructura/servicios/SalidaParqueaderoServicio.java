package co.com.ceibaparqueadero.infraestructura.servicios;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.SalidaParqueaderoLogica;

@RestController
public class SalidaParqueaderoServicio {

	@Autowired
	SalidaParqueaderoLogica salidaParqueaderoLogica;
	
    /**
     * Servicio encargado de registro de salida automotor.
     * @param placa
     * @return
     * @throws ParqueaderoExcepcion
     */
	@PatchMapping("/registro/{placa}")
	public ParqueaderoDto registroSalidaAutomotor(@PathVariable String placa) throws ParqueaderoExcepcion {

		return salidaParqueaderoLogica.registroSalidaAutomotor(placa);

	}

}
