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
import co.com.ceibaparqueadero.dominio.logica.TiempoLogica;
import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

@RestController
@RequestMapping("/api")
public class TiempoServicio {

	@Autowired
	TiempoLogica tiempoLogica;

	/**
	 * Servicio encargado de consultar los tiempos
	 * 
	 * @return
	 */
	@GetMapping("listatiempos")
	public List<Tiempo> listarTiempo() {
		return tiempoLogica.listarTiempo();
	}

	/**
	 * Servicio encargado de crear el tiempo
	 * 
	 * @param detalletiempo
	 * @return
	 */
	@PostMapping("guardartiempo")
	public Respuesta guardarTiempo(@Valid @RequestBody Tiempo detalletiempo) {

		return tiempoLogica.guardarTiempo(detalletiempo);

	}

}
