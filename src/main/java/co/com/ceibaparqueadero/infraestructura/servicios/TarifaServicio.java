package co.com.ceibaparqueadero.infraestructura.servicios;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;

@RestController
@RequestMapping("/api")
public class TarifaServicio {

	@Autowired
	TarifaLogica tarifaLogica;

	/**
	 * Servicio encargado de listar las tarifas
	 * 
	 * @return
	 */
	@GetMapping("/tarifas")
	public List<TarifaEntidad> listarTarifas() {
		return tarifaLogica.listarTarifa();
	}

	/**
	 * Servicio encargado de guardar las tarifas
	 * 
	 * @param detalleTarifa
	 * @return
	 */

	@PostMapping("/tarifas")
	public TarifaDto guardarTarifa(@Valid @RequestBody TarifaDto tarifaDto) throws ParqueaderoExcepcion {

		return tarifaLogica.guardarTarifa(tarifaDto);
	}

}
