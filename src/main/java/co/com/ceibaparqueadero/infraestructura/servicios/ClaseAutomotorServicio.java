package co.com.ceibaparqueadero.infraestructura.servicios;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.exepciones.Respuesta;
import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;

@RestController
@RequestMapping("/api")
public class ClaseAutomotorServicio {

	@Autowired
	ClaseAutomotorLogica claseAutomotorLogica;
	
	

	/**
	 * Servicio en cargado de consultar clase de vehiculo
	 * 
	 * @return List<ClaseAutomotor>
	 */
	@GetMapping("listaclaseautomotor")
	public List<ClaseAutomotorEntidad> listaClases() {

		return claseAutomotorLogica.listarClases();

	}
	
	
	/**
	 * Servicio encargado de guardar clase automotor
	 * @param detalleClase
	 */
    @PostMapping("guardarclasevehiculo")
    public Respuesta guardarClaseVehiculo(@Valid @RequestBody ClaseAutomotorEntidad detalleClase) {
    	
    	return claseAutomotorLogica.guardarClaseAutomor(detalleClase);
    	  		
    }

}
