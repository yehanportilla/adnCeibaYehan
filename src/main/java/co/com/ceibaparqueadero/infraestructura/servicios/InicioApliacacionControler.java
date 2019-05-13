package co.com.ceibaparqueadero.infraestructura.servicios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InicioApliacacionControler {
	@GetMapping
	public String mostrarPagina() {
		return "<center><h2>Bienvenido al sistema Parqueadero Ceiba.<br>Adn yehan Portilla.</h2></center>";
	}
}
