package co.com.ceibaparqueadero.dominio.logica;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.exepciones.Respuesta;
import co.com.ceibaparqueadero.infraestructura.entidades.Tarifa;
import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;
import co.com.ceibaparqueadero.infraestructura.repositorios.ClaseAutomotorRepositorio;
import co.com.ceibaparqueadero.infraestructura.repositorios.TarifaRepositorio;
import co.com.ceibaparqueadero.infraestructura.repositorios.TiempoRepositorio;
import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;

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
	public List<Tarifa> listarTarifa() {
		return tarifaRepositorio.findAll();

	}

	/**
	 * Metodo encargado de guardar la tarifa
	 * 
	 * @param tarifa
	 * @return
	 */
	public Respuesta guardarTarifa(@Valid @RequestBody Tarifa tarifa) {

		Respuesta respuesta = new Respuesta();

		Optional<Tiempo> tiempoBD = tiempoRepositorio.findById(tarifa.getTiempo().getId());
		Optional<ClaseAutomotor> claseBD = claseAutomotorRepositorio.findById(tarifa.getClaseAutomotor().getId());

		if (tiempoBD.isPresent() && claseBD.isPresent()) {

			Tiempo tiempo = tiempoBD.get();
			tarifa.setTiempo(tiempo);

			ClaseAutomotor claseAutomotor = claseBD.get();
			tarifa.setClaseAutomotor(claseAutomotor);

			Tarifa tarifaGuardado = tarifaRepositorio.save(tarifa);

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
