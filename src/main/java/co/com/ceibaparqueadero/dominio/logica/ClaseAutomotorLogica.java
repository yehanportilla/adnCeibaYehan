package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.exepciones.Respuesta;
import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;
import co.com.ceibaparqueadero.infraestructura.repositorios.ClaseAutomotorRepositorio;

@RestController
public class ClaseAutomotorLogica {

	@Autowired
	ClaseAutomotorRepositorio claseAutomotorRepositorio;

	/**
	 * Metodo encargado de consultar las clases de vehiculos
	 * 
	 * @return List<ClaseAutomotor>
	 */
	public List<ClaseAutomotor> listarClases() {
		return claseAutomotorRepositorio.findAll();

	}

	/**
	 * Metodo encargado de guardar la clase automotor
	 * 
	 * @param claseAutomotor
	 * @return
	 */
	public Respuesta guardarClaseAutomor(@Valid @RequestBody ClaseAutomotor detalleClase) {

		Respuesta respuesta = new Respuesta();

		ClaseAutomotor claseAuto = claseAutomotorRepositorio.save(detalleClase);

		if (claseAuto != null) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("Clase: Registrada Exitosamente !");
			respuesta.setClaseAutomotor(claseAuto);
		} else {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Error: Al Registrar!");
		}

		return respuesta;

	}

}
