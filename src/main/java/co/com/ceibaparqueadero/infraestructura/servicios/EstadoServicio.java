package co.com.ceibaparqueadero.infraestructura.servicios;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.logica.EstadoLogica;
import co.com.ceibaparqueadero.dominio.utilidades.Respuesta;
import co.com.ceibaparqueadero.infraestructura.entidades.Estado;

@RestController
@RequestMapping("/api")
public class EstadoServicio {

	@Autowired
	EstadoLogica estadoLogica;

	/**
	 * Servicio encargado de listar los estados
	 * 
	 * @return List<Estado>
	 */
	@GetMapping("listaestados")
	public List<Estado> listarEstado() {
		return estadoLogica.listarEstado();
	}

	/**
	 * Servicio encargado de guardar el estado
	 * 
	 * @param detalleEstado
	 * @return
	 */
	@PostMapping("guardarestado")
	public Respuesta guardarEstado(@Valid @RequestBody Estado detalleEstado) {

		return estadoLogica.guardarEstado(detalleEstado);

	}

}