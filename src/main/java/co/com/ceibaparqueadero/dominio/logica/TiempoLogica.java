package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.aplicacion.repositorio.TiempoRepositorio;
import co.com.ceibaparqueadero.dominio.utilidades.Respuesta;
import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

@RestController
public class TiempoLogica {

	@Autowired
	TiempoRepositorio tiempoRepositorio;

	/**
	 * Metodo encargado de listar tiempos
	 * 
	 * @return List<Tiempo>
	 */
	public List<Tiempo> listarTiempo() {
		return tiempoRepositorio.findAll();

	}
	
	
	 /**
	  * Metodo encargado de guardar el tiempo
	  * @param detalleTiempo
	  * @return
	  */

	public Respuesta guardarTiempo(@Valid @RequestBody Tiempo detalleTiempo) {

		Respuesta respuesta = new Respuesta();

		Tiempo detalle = tiempoRepositorio.save(detalleTiempo);

		if (detalle != null) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("Tiempo: Registrado Exitosamente !");
			respuesta.setTiempo(detalle);
		} else {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Error: Al Registrar!");
		}

		return respuesta;

	}

}
