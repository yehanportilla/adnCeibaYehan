package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.exepciones.Respuesta;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;

@RestController
public class TarifaLogica {

	@Autowired
	TarifaRepositorio tarifaRepositorio;

	@Autowired
	TiempoRepositorio tiempoRepositorio;

	@Autowired
	ClaseAutomotorRepositorio claseAutomotorRepositorio;

	/**
	 * Metodo encargado de listar las tarifas
	 * 
	 * @return List<Tarifa>
	 */
	public List<TarifaEntidad> listarTarifa() {
		return tarifaRepositorio.findAll();

	}

	/**
	 * Metodo encargado de guardar la tarifa
	 * 
	 * @param tarifaEntidad
	 * @return
	 */
	public Respuesta guardarTarifa(@Valid @RequestBody TarifaEntidad tarifaEntidad) {

		Respuesta respuesta = new Respuesta();

		Optional<TiempoEntidad> tiempoBD = tiempoRepositorio.findById(tarifaEntidad.getTiempo().getId());
		Optional<ClaseAutomotorEntidad> claseBD = claseAutomotorRepositorio.findById(tarifaEntidad.getClaseAutomotor().getId());

		if (tiempoBD.isPresent() && claseBD.isPresent()) {

			TiempoEntidad tiempoEntidad = tiempoBD.get();
			tarifaEntidad.setTiempo(tiempoEntidad);

			ClaseAutomotorEntidad claseAutomotorEntidad = claseBD.get();
			tarifaEntidad.setClaseAutomotor(claseAutomotorEntidad);

			TarifaEntidad tarifaGuardado = tarifaRepositorio.save(tarifaEntidad);

			if (tarifaGuardado != null) {

				respuesta.setCodigo(0);
				respuesta.setMensaje("Tarifa: Registrada Exitosamente !");
			} else {
				respuesta.setCodigo(1);
				respuesta.setMensaje("Error: Alguardar Tarifa !");
			}
		} else {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Error: Clase ó Tiempo no existen  !");
		}

		return respuesta;

	}

}
