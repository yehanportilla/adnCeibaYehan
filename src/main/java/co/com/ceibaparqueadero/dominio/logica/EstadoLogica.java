package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.exepciones.Respuesta;
import co.com.ceibaparqueadero.infraestructura.entidades.Estado;
import co.com.ceibaparqueadero.infraestructura.repositorios.EstadoRepositorio;

@RestController
public class EstadoLogica {

	@Autowired
	EstadoRepositorio estadoRepositorio;

	/**
	 * Metodo encargado de listar estado
	 * 
	 * @return List<Estado>
	 */
	public List<Estado> listarEstado() {
		return estadoRepositorio.findAll();
	}

	/**
	 * Metodo encargado de guardar el estado
	 * 
	 * @param detalleEstado
	 * @return
	 */
	public Respuesta guardarEstado(@Valid @RequestBody Estado detalleEstado) {

		Respuesta respuesta = new Respuesta();

		Estado detalle = estadoRepositorio.save(detalleEstado);

		if (detalle != null) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("Estado: Registrado Exitosamente !");
			respuesta.setEstado(detalle);

		} else {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Error: Al Registrar!");
		}

		return respuesta;

	}

}
